package src.simulator;

import java.util.ArrayList;
import src.simulator.vehicles.Flyable;

class Tower {

	private ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		
	}

	public void unregister(Flyable flyable) {

	}

	protected void conditionsChanged() {
		//TODO
	}
}
