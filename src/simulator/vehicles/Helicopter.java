package src.simulator.vehicles;

import src.simulator.WeatherTower;

class Helicopter extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		System.out.println("Heli update");
		String weather = this.weatherTower.getWeather(coordinates);
		System.out.println(weather);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if ("RAIN".equals(weather)) {
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): Rain? I hope there is no lightning");//TODO to file
			this.coordinates = new Coordinates(longitude + 5, latitude, height);
		} else if ("FOG".equals(weather)) {
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): Holy moly. This fog drives me nuts");//TODO to file
			this.coordinates = new Coordinates(longitude + 1, latitude, height);
		} else if ("SUN".equals(weather)) {
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): This sunny weather is so beautiful");//TODO to file
			if (height > 98) {
				this.coordinates = new Coordinates(longitude, latitude + 10, 100);
			} else {
				this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
			}
		} else if ("SNOW".equals(weather)) {
			System.out.println("Helicopter#" + this.name + "(" + this.id + "): This snow might cause a crash. I need to land");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude, height - 12);
		} else {
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
			System.out.println("Helicopter#" + this.name + "(" + this.id + ") landing.");//TODO to file
			this.weatherTower.unregister(this);
			System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");//TODO to file
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");//TODO to file
	}
}
