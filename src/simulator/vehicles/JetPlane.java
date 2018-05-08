package src.simulator.vehicles;

import src.simulator.WeatherTower;
import src.utility.Writer;

class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
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
				Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): Rain? I do not mind to get wet");
				this.coordinates = new Coordinates(longitude, latitude + 5, height);
				break;
			case "FOG":
				Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): Jeez. I don't see anything in this fog");
				this.coordinates = new Coordinates(longitude, latitude + 1, height);
				break;
			case "SUN":
				Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): This sunny weather allows me to fly safely");
				if (height > 98) {
					this.coordinates = new Coordinates(longitude, latitude + 10, 100);
				} else {
					this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
				}
				break;
			case "SNOW":
				Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + "): It is better to find a landing zone due to the snow");
				this.coordinates = new Coordinates(longitude, latitude, height - 7);
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
			Writer.writeIntoAFile("JetPlane#" + this.name + "(" + this.id + ") landing.");
			this.weatherTower.unregister(this);
			Writer.writeIntoAFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		Writer.writeIntoAFile("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
	}
}
