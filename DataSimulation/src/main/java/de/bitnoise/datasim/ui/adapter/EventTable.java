package de.bitnoise.datasim.ui.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import de.bitnoise.datasim.controller.SimulatorControllerProvider;
import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.events.SimulatorTimedEvent;
import de.bitnoise.datasim.ui.SimulatorEventListener;

public class EventTable extends DefaultTableModel implements
		SimulatorEventListener {

	private SimulatorControllerProvider myController;

	public EventTable(SimulatorControllerProvider controller) {
		myController = controller;
		myController.registerEventListener(this);
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	public void setTableWidth(TableColumnModel columnModel) {
		columnModel.getColumn(0).setMaxWidth(160);
		columnModel.getColumn(0).setPreferredWidth(160);
		columnModel.getColumn(1).setMaxWidth(150);
		columnModel.getColumn(1).setPreferredWidth(150);
		columnModel.getColumn(2).setMaxWidth(80);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(2).setPreferredWidth(100);
		columnModel.getColumn(3).setPreferredWidth(10);
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Time";
		case 1:
			return "Type";
		case 2:
			return "Model ID";
		case 3:
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
		List<SimulatorEvent> events = myController.getEventsList();
		if (events.size() <= row) {
			return null;
		}
		SimulatorEvent event = events.get(row);
		switch (column) {
		case 0:
			if (event instanceof SimulatorTimedEvent) {
				Date time = ((SimulatorTimedEvent) event).getOccuranceTime();
				return asTime(time);
			} else {
				return "imediatly";
			}
		case 1:
			return event.getType();
		case 2:
			return event.getTrackingModel().getUniqeID();
		case 3:
			return event.getDetails();
		default:
			return null;
		}
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS");

	private String asTime(Date time) {
		return sdf.format(time);
	}

	@Override
	public int getRowCount() {
		if (myController != null) {
			return myController.getEventsList().size();
		}
		return super.getRowCount();
	}

	public void eventSimulatorEventChanged() {
		fireTableDataChanged();
	}

}
