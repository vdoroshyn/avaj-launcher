package src.simulator.vehicles;

public interface Flyable {
	void updateConditions();
	void registerTower(WeatherTower weatherTower);
}
