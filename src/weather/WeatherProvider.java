package src.weather;

class WeatherProvider {
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private static String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

	private WeatherProvider() {

	}

	public static WeatherProvider getProvider() {
		return this.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates) {

	}
}
