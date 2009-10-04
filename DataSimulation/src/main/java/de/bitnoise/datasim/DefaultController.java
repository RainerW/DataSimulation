package de.bitnoise.datasim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.input.SimulatorTimedEvent;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;

public class DefaultController implements SimulatorControllerProvider {

	List<SimulatorEvent> events = new ArrayList<SimulatorEvent>();
	SortedList<SimulatorTimedEvent> timedEvents = new SortedList<SimulatorTimedEvent>(
			new TimedEventComparator());

	List<SimulatorModel> models = new ArrayList<SimulatorModel>();

	public boolean addEvent(SimulatorEvent... eventToExecute) {
		if (eventToExecute == null) {
			return false;
		}
		for (SimulatorEvent event : eventToExecute) {
			if (event instanceof SimulatorTimedEvent) {
				timedEvents.add((SimulatorTimedEvent) event);
			} else {
				events.add(event);
			}
		}
		return false;
	}

	static protected class TimedEventComparator implements
			Comparator<SimulatorTimedEvent> {

		public int compare(SimulatorTimedEvent o1, SimulatorTimedEvent o2) {
			return o1.getOccuranceTime().compareTo(o2.getOccuranceTime());
		}
	}

	public boolean addEvent(List<SimulatorEvent> eventToExceut) {
		if (eventToExceut == null) {
			return false;
		}
		return addEvent(eventToExceut.toArray(new SimulatorEvent[] {}));
	}

	public boolean addModel(SimulatorModel... modelItemToAdd) {
		if (modelItemToAdd == null) {
			return false;
		}
		for (SimulatorModel model : modelItemToAdd) {
			models.add(model);
		}
		return false;
	}

	public boolean addModel(List<SimulatorModel> modelItemToAdd) {
		if (modelItemToAdd == null) {
			return false;
		}
		return addModel(modelItemToAdd.toArray(new SimulatorModel[] {}));
	}

	public void processEvents() {

	}

	public List<SimulatorEvent> getEventsList(Date currentTime) {
		List<SimulatorEvent> result = new ArrayList<SimulatorEvent>();
		result = events;
		events = new ArrayList<SimulatorEvent>();

		for (Iterator<SimulatorTimedEvent> iter = timedEvents.iterator(); iter
				.hasNext();) {
			SimulatorTimedEvent event = iter.next();
			if (event.getOccuranceTime().before(currentTime)) {
				iter.remove();
				result.add(event);
			}
		}
		return result;
	}

	public void printState() {
		int c = 0;
		for (SimulatorModel model : models) {
			if (model.getModelState() != ModelState.OK) {
				
				System.out.println("" +model.getUniqeID() + "\t" + model.getModelState());
			} else {
				c++;
			}
		}
		System.out.println("ok = " + c);

	}

}
