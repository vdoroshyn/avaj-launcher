package src.simulator.vehicles;

import src.simulator.WeatherTower;

class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {

	}

	public void registerTower(WeatherTower weatherTower) {
		
	}
}
