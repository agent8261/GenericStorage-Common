package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class NoUserException extends MyDeskException
{

  public NoUserException()
  {
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public NoUserException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public NoUserException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public NoUserException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

}
