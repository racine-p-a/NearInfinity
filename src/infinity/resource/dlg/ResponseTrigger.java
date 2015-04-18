// Near Infinity - An Infinity Engine Browser and Editor
// Copyright (C) 2001 - 2005 Jon Olav Hauglid
// See LICENSE.txt for license information

package infinity.resource.dlg;

public final class ResponseTrigger extends AbstractCode
{
  public static final String FMT_NAME = "Response trigger %1$d";

  private int nr;

  ResponseTrigger()
  {
    super("Response trigger");
  }

  ResponseTrigger(byte buffer[], int offset, int count)
  {
    super(buffer, offset, String.format(FMT_NAME, count));
    this.nr = count;
  }

  public int getNumber()
  {
    return nr;
  }
}
