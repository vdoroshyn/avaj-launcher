package src.simulator.vehicles;

import src.simulator.WeatherTower;

class JetPlane extends Aircraft implements Flyable {
	
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates) {
		super(name, coordinates);
	}

	public void updateConditions() {
		System.out.println("Plane update");
		String weather = this.weatherTower.getWeather(coordinates);
		System.out.println(weather);
		int longitude = this.coordinates.getLongitude();
		int latitude = this.coordinates.getLatitude();
		int height = this.coordinates.getHeight();

		if ("RAIN".equals(weather)) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): Rain? I do not mind to get wet");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude + 5, height);
		} else if ("FOG".equals(weather)) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): Jeez. I don't see anything in this fog");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude + 1, height);
		} else if ("SUN".equals(weather)) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): This sunny weather allows me to fly safely");//TODO to file
			if (height > 98) {
				this.coordinates = new Coordinates(longitude, latitude + 10, 100);
			} else {
				this.coordinates = new Coordinates(longitude, latitude + 10, height + 2);
			}
		} else if ("SNOW".equals(weather)) {
			System.out.println("JetPlane#" + this.name + "(" + this.id + "): It is better to find a landing zone due to the snow");//TODO to file
			this.coordinates = new Coordinates(longitude, latitude, height - 7);
		} else {
			System.out.println("This condition is not supported in this program");
		}
		//TODO unregister if height <= 0
	}

	public void registerTower(WeatherTower weatherTower) {
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
		System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");//TODO to file
	}
}
