package src.simulator;

import java.util.ArrayList;
import src.simulator.vehicles.Flyable;

class Tower {

	public ArrayList<Flyable> observers = new ArrayList<Flyable>();//TODO private

	public void register(Flyable flyable) {
		if (!this.observers.contains(flyable)) {
			this.observers.add(flyable);
		}
	}

	public void unregister(Flyable flyable) {
		if (this.observers.contains(flyable)) {
			this.observers.remove(flyable);
		}
	}

	protected void conditionsChanged() {
		//TODO
		for (int i = 0; i < this.observers.size(); ++i) {
			this.observers.get(i).updateConditions();
		}
	}
}
