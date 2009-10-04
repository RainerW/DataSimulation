package de.bitnoise.datasim.gui.adapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

import javax.swing.ListSelectionModel;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import de.bitnoise.datasim.SimulatorControllerProvider;
import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.input.SimulatorTimedEvent;
import de.bitnoise.datasim.ui.SimulatorEventListener;

public class EventTable extends DefaultTableModel implements
		SimulatorEventListener {

	private SimulatorControllerProvider myController;

	public EventTable(SimulatorControllerProvider controller) {
		myController = controller;
		myController.registerModelListener(this);
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	public void setTableWidth(TableColumnModel tableColumnModel) {
		tableColumnModel.getColumn(0).setMaxWidth(60);
		tableColumnModel.getColumn(1).setMaxWidth(160);
		tableColumnModel.getColumn(1).setPreferredWidth(160);
		tableColumnModel.getColumn(2).setMaxWidth(80);
		tableColumnModel.getColumn(2).setPreferredWidth(80);
		tableColumnModel.getColumn(2).setPreferredWidth(100);
		tableColumnModel.getColumn(3).setPreferredWidth(10);
	}

	@Override
	public String getColumnName(int column) {
		switch (column) {
		case 0:
			return "Type";
		case 1:
			return "Time";
		case 2:
			return "Tracking ID";
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
			return event.getOutputWriterType();
		case 1:
			if (event instanceof SimulatorTimedEvent) {
				Date time = ((SimulatorTimedEvent) event).getOccuranceTime();
				return asTime(time);
			} else {
				return "imediatly";
			}
		case 2:
			return event.getTrackingModel().getUniqeID();
		case 3:
			return event.getDetails();
		default:
			return null;
		}
	}

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss.SSS");

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
