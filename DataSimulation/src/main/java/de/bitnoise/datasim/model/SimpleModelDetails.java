package de.bitnoise.datasim.model;

public class SimpleModelDetails implements ModelDetail
{

  private ModelState fState;

  public void setState(ModelState state)
  {
    fState = state;
  }

  public void setDetail(String detail)
  {
    fDetail = detail;
  }

  private String fDetail;

  public SimpleModelDetails( String detail)
  {
  this(ModelState.RUNNING,detail);
  }

  public SimpleModelDetails(ModelState initialSate, String detail)
  {
    fState = initialSate;
    fDetail = detail;
  }

  public String getDetails()
  {
    return fDetail;
  }

  public ModelState getModelState()
  {
    return fState;
  }

}
