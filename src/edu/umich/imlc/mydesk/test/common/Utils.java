package edu.umich.imlc.mydesk.test.common;

import java.io.File;
import java.util.UUID;

import android.net.Uri;
import android.util.Log;

public class Utils
{
  public static void printMethodName(String TAG)
  {
    String temp = (new Throwable("dummy")).getStackTrace()[1].toString();
    int end = temp.indexOf("(");
    int start = temp.lastIndexOf(".", temp.lastIndexOf(".", end) - 1) + 1;
    String mName = new String(temp.substring(start, end) + "()");
    Log.i(TAG, mName);
  }
  
  public static Uri createRandomFileUri(File filesDir)
  {
    printMethodName(Utils.class.getSimpleName());
    UUID fileName = UUID.randomUUID();
    
    return Uri.withAppendedPath(Uri.fromFile(filesDir), fileName.toString());
  }// createRandomFileUri
}
