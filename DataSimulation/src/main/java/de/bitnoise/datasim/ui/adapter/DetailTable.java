package de.bitnoise.datasim.ui.adapter;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import de.bitnoise.datasim.model.ModelDetail;
import de.bitnoise.datasim.model.SimulatorModel;

public class DetailTable extends DefaultTableModel
{

  private SimulatorModel myModel;

  public DetailTable(SimulatorModel model)
  {
    myModel = model;
  }

  @Override
  public int getColumnCount()
  {
    return 2;
  }

  @Override
  public int getRowCount()
  {
    if (myModel != null)
    {
      return myModel.getModelDetails().size();
    }
    return super.getRowCount();
  }
  
  @Override
  public String getColumnName(int column)
  {
    switch (column)
    {
    case 0:
      return "Status";
    case 1:
      return "Details";
    default:
      return "";
    }
  }

  @Override
  public Object getValueAt(int row, int column)
  {
    if (myModel == null)
    {
      return null;
    }
    List<ModelDetail> details = myModel.getModelDetails();
    if (details.size() <= column)
    {
      return null;
    }
    ModelDetail data = details.get(row);
    switch (column)
    {
    case 0:
      return data.getModelState();
    case 1:
      return data.getDetails();
    default:
      return null;
    }

  }

}
