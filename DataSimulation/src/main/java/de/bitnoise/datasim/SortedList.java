package de.bitnoise.datasim;

import java.util.*;

public class SortedList<T> extends ArrayList<T> {
	private Comparator<T> comparator;

	public SortedList(Comparator<T> c) {
		this.comparator = c;
	}

	public void add(int index, T element) {
		return;
	}

	public boolean add(T o) {
		int i = 0;
		boolean found = false;
		while (!found && (i < size())) {
			found = comparator.compare(o, get(i)) < 0;
			if (!found)
				i++;
		}
		super.add(i, o);
		return true;
	}
}
