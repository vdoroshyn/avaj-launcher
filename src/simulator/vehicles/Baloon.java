package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.simulator.Simulator;

class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		String weather = this.weatherTower.getWeather(coordinates);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if ("RAIN".equals(weather)) {
			Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): Holy hell. I might get hurt in this rain");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude, height - 5);
		} else if ("FOG".equals(weather)) {
			Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): The fog does not hinder my movements");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude, height - 3);
		} else if ("SUN".equals(weather)) {
			Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): The sun allows me to rise and shine");//TODO to file
			if (height > 96) {
				this.coordinates = new Coordinates(longitude, latitude + 10, 100);
			} else {
				this.coordinates = new Coordinates(longitude, latitude + 10, height + 4);
			}
		} else if ("SNOW".equals(weather)) {
			Simulator.writer.println("Baloon#" + this.name + "(" + this.id + "): Houston! I am crashing. I am crashing.");//TODO to file
			this.coordinates = new Coordinates(longitude + 2, latitude, height - 15);
		} else {
			/*
			**exception would have been a better choice
			**but the interface and classes should be done according to the UML
			*/
			Simulator.writer.println("This condition is not supported in this program");
		}
		/*
		**The height is checked here whether the aircraft has to land
		*/
		if (this.coordinates.getHeight() <= 0) {
			Simulator.writer.println("Baloon#" + this.name + "(" + this.id + ") landing.");//TODO to file
			this.weatherTower.unregister(this);
			Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");//TODO to file
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Simulator.writer.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");//TODO to file
	}
}
