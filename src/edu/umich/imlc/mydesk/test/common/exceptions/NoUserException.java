package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class NoUserException extends MyDeskException
{
  public static final String TAG = "NoUserException";
  public NoUserException()
  {
    Utils.printMethodName(TAG);
  }

  public NoUserException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName(TAG);
  }

  public NoUserException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName(TAG);
  }

  public NoUserException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName(TAG);
  }

}
