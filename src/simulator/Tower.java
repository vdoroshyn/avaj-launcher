package src.simulator;

import java.util.ArrayList;
import src.simulator.vehicles.Flyable;

class Tower {

	public ArrayList<Flyable> observers = new ArrayList<Flyable>();

	public void register(Flyable flyable) {
		
	}

	public void unregister(Flyable flyable) {

	}

	protected void conditionsChanged() {
		// System.out.println("ebalo");//TODO
	}
}
