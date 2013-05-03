package edu.umich.imlc.mydesk.test.common;

import edu.umich.imlc.mydesk.test.common.exceptions.FileLockedException;
import edu.umich.imlc.mydesk.test.common.exceptions.MyDeskException;
import edu.umich.imlc.mydesk.test.common.exceptions.FileConflictException;
import edu.umich.imlc.mydesk.test.common.exceptions.NoUserException;
import edu.umich.imlc.mydesk.test.common.exceptions.NotOwnerException;
import android.content.ComponentName;
import android.database.Cursor;
import android.net.Uri;

public final class GenericContract
{
  public static final String TAG = "GenericContract";
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
  public static final String SHARED_PREFS = "sharedPrefs";
  public static final String PREFS_ACCOUNT_NAME = "accountName";
  public static final String CALLER_IS_SYNC_ADAPTER = "caller_is_sync_adapter";
  public static final String UNLOCK_FILE = "clean_file";
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
    public static final String BACKEND_CONFLICTS = "backend_conflicts";

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
    public static final String CONFLICT = "conflict";

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
        MetaDataColumns.LOCKED, MetaDataColumns.CONFLICT };

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

  public static final class BackendConflictColumns
  {
    public static final String ID = "_id";
    public static final String FILE_ID = "file_id";
    public static final String RESOLVED = "resolved";

    private BackendConflictColumns()
    {

    }
  }// BackendConflictColumns

  public static final class MetaData
  {
    public static final String TAG = "MetaData";
    private final String fileId;
    private final String fileName;
    private final String fileType;
    private final String owner;
    private final Uri fileUri;
    private final int sequenceNumber;
    private final boolean dirty;
    private final boolean locked;
    private final boolean conflict;

    // -------------------------------------------------------------------------
    // -------------------------------------------------------------------------

    public MetaData(Cursor c)
    {
      Utils.printMethodName(TAG);
      fileId = c.getString(0);
      fileName = c.getString(1);
      fileType = c.getString(2);
      owner = c.getString(3);
      fileUri = Uri.parse(c.getString(4));
      sequenceNumber = c.getInt(5);
      dirty = c.getInt(6) == 1;
      locked = c.getInt(7) == 1;
      conflict = c.getInt(8) == 1;
    }// ctor

    // -------------------------------------------------------------------------

    public String fileId()
    {
      Utils.printMethodName(TAG);
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
      Utils.printMethodName(TAG);
      return fileType;
    }

    // -------------------------------------------------------------------------

    public String Owner()
    {
      Utils.printMethodName(TAG);
      return owner;
    }

    // -------------------------------------------------------------------------

    public Uri fileUri()
    {
      Utils.printMethodName(TAG);
      return fileUri;
    }

    // -------------------------------------------------------------------------

    public int sequenceNumber()
    {
      Utils.printMethodName(TAG);
      return sequenceNumber;
    }

    // -------------------------------------------------------------------------

    public boolean dirty()
    {
      Utils.printMethodName(TAG);
      return dirty;
    }

    // -------------------------------------------------------------------------

    public boolean locked()
    {
      Utils.printMethodName(TAG);
      return locked;
    }

    // -------------------------------------------------------------------------

    public boolean conflict()
    {
      return conflict;
    }

    // -------------------------------------------------------------------------

    @Override
    public String toString()
    {
      Utils.printMethodName(TAG);
      return "\n{\n  FileId: " + fileId + "\n  FileName: " + fileName + "\n  FileType:" + fileType
          + "\n  FileUri:" + fileUri + "\n  Seq:" + sequenceNumber + "\n  Dirty:" + dirty + "\n  Conflict:"
          + conflict + "\n}\n";
    }

  }// MetaData

  // ---------------------------------------------------------------------------

  public static enum LocalResolve
  {
    NEW, EXISTING;
  }// LocalResolve

  // ---------------------------------------------------------------------------

  public static enum BackendResolve
  {
    LOCAL, BACKEND;
  }// BackendResolve

  // ---------------------------------------------------------------------------

  public static enum Exceptions
  {
    FILECONFLICTEXCEPTION
    {
      @Override
      public MyDeskException createException()
      {
        return new FileConflictException();
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
    },
    FILELOCKEDEXCEPTION
    {
      @Override
      public MyDeskException createException()
      {
        return new FileLockedException();
      }
    };
    public abstract MyDeskException createException();
  }// Exceptions

  // ---------------------------------------------------------------------------

}
