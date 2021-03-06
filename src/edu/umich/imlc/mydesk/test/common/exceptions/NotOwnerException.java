package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class NotOwnerException extends MyDeskException
{
  public static final String TAG = "NotOwnerException";
  public NotOwnerException()
  {
    Utils.printMethodName(TAG);
  }

  public NotOwnerException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName(TAG);
  }

  public NotOwnerException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName(TAG);
  }

  public NotOwnerException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName(TAG);
  }

}
