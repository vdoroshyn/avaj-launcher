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
			this.coordinates = new Coordinates(longitude + 5, latitude, height);
		} else if ("FOG".equals(weather)) {
			this.coordinates = new Coordinates(longitude + 1, latitude, height);
		} else if ("SUN".equals(weather)) {
			this.coordinates = new Coordinates(longitude + 10, latitude, height + 2);
		} else if ("SNOW".equals(weather)) {
			this.coordinates = new Coordinates(longitude, latitude, height - 12);
		} else {
			System.out.println("This condition is not supported in this program");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");//TODO to file
	}
}
