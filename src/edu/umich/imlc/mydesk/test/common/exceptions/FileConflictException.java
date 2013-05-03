package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class FileConflictException extends MyDeskException
{
  public static final String TAG = "LocalConflictException";
  public FileConflictException()
  {
    Utils.printMethodName(TAG);
  }

  public FileConflictException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName(TAG);
  }

  public FileConflictException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName(TAG);
  }

  public FileConflictException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName(TAG);
  }

}
