package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.utility.Writer;

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

		/*
		**weather cannot be null in this version of the program, so I did not add another if conditional 
		**the check should be here
		*/
		switch(weather) {
			case "RAIN":
				Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): Holy hell. I might get hurt in this rain");
				this.coordinates = new Coordinates(longitude, latitude, height - 5);
				break;
			case "FOG":
				Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): The fog does not hinder my movements");
				this.coordinates = new Coordinates(longitude, latitude, height - 3);
				break;
			case "SUN":
				Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): The sun allows me to rise and shine");
				if (height > 96) {
					this.coordinates = new Coordinates(longitude + 2, latitude, 100);
				} else {
					this.coordinates = new Coordinates(longitude + 2, latitude, height + 4);
				}
				break;
			case "SNOW":
				Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + "): Houston! I am crashing. I am crashing.");
				this.coordinates = new Coordinates(longitude, latitude, height - 15);
				break;
			default:
				/*
				**exception would have been a better choice
				**but the interface and classes should be done according to the UML
				*/
				System.out.println("This condition is not supported in this program");
		}
		/*
		**The height is checked here whether the aircraft has to land
		*/
		if (this.coordinates.getHeight() <= 0) {
			Writer.writeIntoAFile("Baloon#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			Writer.writeIntoAFile("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Writer.writeIntoAFile("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
