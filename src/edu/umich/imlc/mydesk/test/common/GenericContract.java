package edu.umich.imlc.mydesk.test.common;

import edu.umich.imlc.mydesk.test.common.exceptions.MyDeskException;
import edu.umich.imlc.mydesk.test.common.exceptions.LocalConflictException;
import edu.umich.imlc.mydesk.test.common.exceptions.NoUserException;
import edu.umich.imlc.mydesk.test.common.exceptions.NotOwnerException;
import android.content.ComponentName;
import android.database.Cursor;
import android.net.Uri;

public final class GenericContract
{
  public static final String AUTHORITY = "edu.umich.imlc.mydesk.test.service.provider";
  public static final Uri URI_BASE = Uri.parse("content://" + AUTHORITY);
  public static final Uri URI_FILES = Uri.withAppendedPath(URI_BASE,
      Uri.encode("files"));
  public static final Uri URI_CURRENT_ACCOUNT = Uri.withAppendedPath(URI_BASE,
      Uri.encode("current_account"));
  public static final String KEY_FILE_NAME = "fileName";
  public static final String KEY_NEW_FILE = "newFile";
  public static final String KEY_UPDATE_SOURCE = "updateSource";
  public static final String KEY_UPDATE_OLD_SEQUENCE = "update_old_sequence";
  public static final String KEY_UPDATE_BACKEND = "from_backend";
  public static final String SHARED_PREFS = "sharedPrefs";
  public static final String PREFS_ACCOUNT_NAME = "accountName";
  public static final String CALLER_IS_SYNC_ADAPTER = "caller_is_sync_adapter";
  public static final String CLEAN_FILE = "clean_file";
  public static final String LOCK_FILE = "lock_file";
  public static final ComponentName COMPONENT_LOGIN_ACTIVITY = new ComponentName(
      "edu.umich.imlc.mydesk.test.service",
      "edu.umich.imlc.mydesk.test.auth.LoginActivty");

  public static final String KEY_CHOOSE_ACCOUNT = "chooseNewAccount";
  
  // ---------------------------------------------------------------------------
  // ---------------------------------------------------------------------------

  private GenericContract()
  {
  }

  /**
   * @author Adrian Tables available in GenericProvider
   */
  public static final class Tables
  {
    public static final String METADATA = "metadata";
    public static final String LOCAL_CONFLICTS = "local_conflicts";

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------

    private Tables()
    {

    }
  }// Tables

  /**
   * @author Adrian Columns of the MetaData table
   */
  public static final class MetaDataColumns
  {
    public static final String ID = "_id";
    public static final String FILE_ID = "file_id";
    public static final String NAME = "name";
    public static final String TYPE = "file_type";
    public static final String OWNER = "owner";
    public static final String URI = "uri";
    public static final String TIME = "timestamp";
    public static final String SEQUENCE = "sequence_no";
    public static final String DIRTY = "dirty_bit";
    public static final String LOCKED = "locked";

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    private MetaDataColumns()
    {

    }
  }// MetaDataColumns

  /**
   * @author Adrian Projections to use with the MetaData table
   */
  public static final class MetaDataProjections
  {
    public static final String[] METADATA = { MetaDataColumns.FILE_ID,
        MetaDataColumns.NAME, MetaDataColumns.TYPE, MetaDataColumns.OWNER,
        MetaDataColumns.URI, MetaDataColumns.SEQUENCE, MetaDataColumns.DIRTY,
        MetaDataColumns.LOCKED };

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
  }// MetaDataProjections

  /**
   * @author Adrian Columns of the LocalConflicts table
   */
  public static final class LocalConflictColumns
  {
    public static final String ID = "_id";
    public static final String FILE_ID = "file_id";
    public static final String NEWFILE_URI = "new_file_uri";
    public static final String NEWFILE_TIMESTAMP = "new_file_timestamp";
    public static final String RESOLVED = "resolved";

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    private LocalConflictColumns()
    {

    }
  }// LocalConflictColumns

  public static final class MetaData
  {
    private final String fileId;
    private final String fileName;
    private final String fileType;
    private final String owner;
    private final Uri fileUri;
    private final int sequenceNumber;
    private final boolean dirty;
    private final boolean locked;

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------
    public MetaData(Cursor c)
    {
      fileId = c.getString(0);
      fileName = c.getString(1);
      fileType = c.getString(2);
      owner = c.getString(3);
      fileUri = Uri.parse(c.getString(4));
      sequenceNumber = c.getInt(5);
      dirty = c.getInt(6) == 1;
      locked = c.getInt(7) == 1;
    }// ctor

    // -------------------------------------------------------------------------

    public String fileId()
    {
      return fileId;
    }

    // -------------------------------------------------------------------------

    public String fileName()
    {
      return fileName;
    }

    // -------------------------------------------------------------------------

    public String fileType()
    {
      return fileType;
    }

    // -------------------------------------------------------------------------

    public String Owner()
    {
      return owner;
    }

    // -------------------------------------------------------------------------

    public Uri fileUri()
    {
      return fileUri;
    }

    // -------------------------------------------------------------------------

    public int sequenceNumber()
    {
      return sequenceNumber;
    }

    // -------------------------------------------------------------------------

    public boolean dirty()
    {
      return dirty;
    }

    // -------------------------------------------------------------------------

    public boolean locked()
    {
      return locked;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString()
    {
      return "\n{\n  " + fileId + "\n  " + fileName + "\n  " + fileType + "\n  " + fileUri
          + "\n  " + sequenceNumber + "\n  " + dirty + "\n}\n";
    }
  }// MetaData

  // ---------------------------------------------------------------------------

  public static enum LocalResolve
  {
    NEW, EXISTING;
  }// LocalResolve

  // ---------------------------------------------------------------------------

  public static enum Exceptions
  {
    LOCALCONFLICTEXCEPTION
    {
      @Override
      public MyDeskException createException()
      {
        return new LocalConflictException();
      }
    },
    NOUSEREXCEPTION
    {
      @Override
      public MyDeskException createException()
      {
        return new NoUserException();
      }
    },
    NOTOWNEREXCEPTION
    {
      @Override
      public MyDeskException createException()
      {
        return new NotOwnerException();
      }
    };
    public abstract MyDeskException createException();
  }// Exceptions

  // ---------------------------------------------------------------------------

}
