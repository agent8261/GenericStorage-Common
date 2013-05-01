package edu.umich.imlc.mydesk.test.common.exceptions;

import edu.umich.imlc.mydesk.test.common.Utils;

@SuppressWarnings("serial")
public class LocalConflictException extends MyDeskException
{

  public LocalConflictException()
  {
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public LocalConflictException(String detailMessage)
  {
    super(detailMessage);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public LocalConflictException(Throwable throwable)
  {
    super(throwable);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

  public LocalConflictException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    Utils.printMethodName();
    // TODO Auto-generated constructor stub
  }

}
