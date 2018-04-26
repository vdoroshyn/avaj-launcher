package src.simulator.vehicles;

class Aircraft {
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates) {
		this.name = name;
		this.Coordinates = coordinates;
		this.id = this.nextId();
	}

	private long nextId() {
		return ++(this.idCounter);
	}
}
