package de.bitnoise.datasim.gui.adapter;

import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import de.bitnoise.datasim.SimulatorControllerProvider;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorModelListener;

public class ModelTable extends DefaultTableModel implements
		SimulatorModelListener {

	private SimulatorControllerProvider myController;
	private ModelState[] myfilters;

	public ModelTable(SimulatorControllerProvider controller,
			ModelState... stateFilters) {
		myController = controller;
		myController.registerModelListener(this);
		myfilters = stateFilters;
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	public void setTableWidth(TableColumnModel columnModel) {
		columnModel.getColumn(0).setMaxWidth(160);
		columnModel.getColumn(0).setPreferredWidth(160);
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Model-Id";
		case 1:
			return "State";
		case 2:
			return "Details";
		default:
			return "-";
		}
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (myController == null) {
			return null;
		}
		List<SimulatorModel> models = myController.getModelList(myfilters);
		if (models.size() <= row) {
			return null;
		}
		SimulatorModel model = models.get(row);
		switch (column) {
		case 0:
			return model.getUniqeID();
		case 1:
			return model.getModelState();
		case 2:
			return model.getDetails();
		default:
			return null;
		}
	}

	@Override
	public int getRowCount() {
		if (myController == null) {
			return super.getRowCount();
		}
		return myController.getModelList(myfilters).size();
	}

	public void eventSimulatorModelChanged(SimulatorModel changedModel) {
		fireTableDataChanged();
	}

}
