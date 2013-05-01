package edu.umich.imlc.mydesk.test.common.exceptions;

@SuppressWarnings("serial")
public class NotOwnerException extends MyDeskException
{

  public NotOwnerException()
  {
    // TODO Auto-generated constructor stub
  }

  public NotOwnerException(String detailMessage)
  {
    super(detailMessage);
    // TODO Auto-generated constructor stub
  }

  public NotOwnerException(Throwable throwable)
  {
    super(throwable);
    // TODO Auto-generated constructor stub
  }

  public NotOwnerException(String detailMessage, Throwable throwable)
  {
    super(detailMessage, throwable);
    // TODO Auto-generated constructor stub
  }

}
