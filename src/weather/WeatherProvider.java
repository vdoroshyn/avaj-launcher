package src.weather;

class WeatherProvider {
	
	private static WeatherProvider weatherProvider = null;
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {}

	public static WeatherProvider getProvider() {
		if (this.weatherProvider == null) {
			this.weatherProvider = new WeatherProvider();
		}
		return this.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {
		int randNumber = (coordinates.getLongitude() + coordinates.getLatitude() + coordintes.getHeight()) / 3;
		return weather[randNumber % 4];
	}
}
