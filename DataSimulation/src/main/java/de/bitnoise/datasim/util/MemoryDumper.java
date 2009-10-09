package de.bitnoise.datasim.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;


/**
 * Hilfsklasse zum loggen des Speicherverbrauchs
 */
public class MemoryDumper
{


  private String fDumpFileName;

  private int fDelayInSeconds;

  private long fLastRun;

  /**
   * Erzeug eine neue Memory Dumper Instanz.
   * 
   * @param dumpFileName Die Datei in welceh geloggt werden solld
   * @param delayInSeconds Der Zeitabstand zwischen Zei log Vorgängen
   *        (Getestet wird der Zeitablauf immer bei einem dump()
   *        Aufruf)
   * 
   */
  public MemoryDumper(String dumpFileName, int delayInSeconds)
  {
    fDumpFileName = dumpFileName;
    fDelayInSeconds = delayInSeconds;
    fLastRun = 0;
  }

  /**
   * Do dump the memory.
   * 
   * Wird aber nur gemacht wenn die definierte Zeitspanne abgelaufen
   * ist.
   */
  public void dump()
  {
    if (fDumpFileName == null)
    {
      return;
    }
    if (fLastRun < System.currentTimeMillis())
    {
      fLastRun = System.currentTimeMillis() + (fDelayInSeconds * 1000);

      writeHeader(fDumpFileName);

      StringBuffer sb = new StringBuffer();

      sb.append(new Date().toString());
      sb.append(",");

      appendMemoryData(sb);

      System.gc();

      appendMemoryData(sb);


      sb.append("\r\n");

      appendToFile(sb, fDumpFileName);
    }
  }

  private void appendToFile(StringBuffer sb, String filename)
  {
    FileOutputStream fileOutputStream;
    try
    {
      fileOutputStream = new FileOutputStream(new File(filename), true);
      fileOutputStream.write(sb.toString().getBytes());
      fileOutputStream.close();
    }
    catch (Throwable e)
    {
    }
  }

  private void appendMemoryData(StringBuffer sb)
  {

    sb.append(Runtime.getRuntime().freeMemory());
    sb.append(",");
    sb.append(Runtime.getRuntime().totalMemory());
    sb.append(",");
  }

  private void writeHeader(String dumpFileName)
  {
    if (!new File(dumpFileName).exists())
    {
      FileOutputStream fileOutputStream;
      try
      {
        fileOutputStream = new FileOutputStream(new File(dumpFileName), true);
        fileOutputStream
            .write("Datum,Free-Mem before,Total-Mem before,Free-Mem after,Total-Mem after,Your Parameters\r\n"
                .getBytes());
        fileOutputStream.close();
      }
      catch (Throwable e1)
      {
      }
    }
  }
}
