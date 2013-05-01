package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class NotOwnerException extends MyDeskException
{

  public NotOwnerException()
  {
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public NotOwnerException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public NotOwnerException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public NotOwnerException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

}
