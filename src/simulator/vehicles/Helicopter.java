package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.utility.Writer;

class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
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
				Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): Rain? I hope there is no lightning");
				this.coordinates = new Coordinates(longitude + 5, latitude, height);
				break;
			case "FOG":
				Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): Holy moly. This fog drives me nuts");
				this.coordinates = new Coordinates(longitude + 1, latitude, height);
				break;
			case "SUN":
				Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): This sunny weather is so beautiful");
				if (height > 98) {
					this.coordinates = new Coordinates(longitude + 10, latitude, 100);
				} else {
					this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
				}
				break;
			case "SNOW":
				Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + "): This snow might cause a crash. I need to land");
				this.coordinates = new Coordinates(longitude, latitude, height - 12);
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
			Writer.writeIntoAFile("Helicopter#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			Writer.writeIntoAFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Writer.writeIntoAFile("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
