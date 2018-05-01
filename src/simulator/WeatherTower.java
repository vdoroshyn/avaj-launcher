package src.simulator;

import src.simulator.Tower;
import src.simulator.vehicles.Coordinates;

public class WeatherTower extends Tower {

	public String getWeather(Coordinates coordinates) {
		return "weather";//TODO
	}

	void changeWeather() {
		this.conditionsChanged();
	}
}
