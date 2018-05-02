package src.simulator.vehicles;

import src.simulator.WeatherTower;
// import src.weather.WeatherProvider;

class Baloon extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		System.out.println("Baloon update");
		String weather = this.weatherTower.getWeather(coordinates);
		System.out.println(weather);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if ("RAIN".equals(weather)) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): Holy hell. I might get hurt in this rain");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude, height - 5);
		} else if ("FOG".equals(weather)) {
			this.coordinates = new Coordinates(longitude, latitude, height - 3);
		} else if ("SUN".equals(weather)) {
			this.coordinates = new Coordinates(longitude, latitude, height + 4);
		} else if ("SNOW".equals(weather)) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): I must land in this snow or I crash");//TODO to file
			this.coordinates = new Coordinates(longitude + 2, latitude, height - 15);
		} else {
			System.out.println("This condition is not supported in this program");
		}
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");//TODO to file
	}
}
