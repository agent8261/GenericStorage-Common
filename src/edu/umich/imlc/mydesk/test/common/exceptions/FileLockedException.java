package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class FileLockedException extends MyDeskException
{
  public static final String TAG = "FileLockedException";
  public FileLockedException()
  {
    Utils.printMethodName(TAG);
  }

  public FileLockedException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName(TAG);
  }

  public FileLockedException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName(TAG);
  }

  public FileLockedException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName(TAG);
  }

}
