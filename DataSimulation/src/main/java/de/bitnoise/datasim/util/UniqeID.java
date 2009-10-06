package de.bitnoise.datasim.util;

import java.text.Format;

public class UniqeID
{

  protected static Long uniqueBaseID = 1L;

  public static Long generate()
  {
    synchronized (uniqueBaseID)
    {
      uniqueBaseID++;
    }
    return uniqueBaseID;
  }

  public static String generateAsString()
  {
    return generate().toString();
  }

  public static String fillup(int id, int fillup, String postfix)
  {
    return fillup((long) id, fillup, postfix);
  }

  public static String fillup(Long uniqeID, int fillup, String postfix)
  {
    String temp = Long.toString(uniqeID);
    int c = fillup - temp.length();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < c; i++)
    {
      sb.append("0");
    }
    sb.append(temp);
    sb.append(postfix);
    return sb.toString();
  }
}
