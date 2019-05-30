package main.model;

import java.util.ArrayList;

public class MapModel {
	private ArrayList<Disaster> disasters;

	public MapModel() {
		disasters = new ArrayList<Disaster>();
	}

	public void addDisaster(Disaster disaster) {
		disasters.add(disaster);
	}

	public ArrayList<Disaster> getDisasters() {
		return disasters;
	}

	public Disaster getDisaster(int index) {
		return disasters.get(index);
	}

}
