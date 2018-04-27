package src.simulator;

class Validator {
	public static void validateLine(String line) {
		String[] splitLine = line.split(" ");
		validateType(splitLine[0]);
		validateCoordinates(splitLine);
	}

	private static void validateType(String type) {
		if (!"Baloon".equals(type)     &&
			!"Helicopter".equals(type) &&
			!"JetPlane".equals(type)) {
			System.out.println("huylo");
		}
	}

	private static void validateCoordinates(String[] coordinates) {
		Integer.parseInt(coordinates[2]);
		Integer.parseInt(coordinates[3]);
		Integer.parseInt(coordinates[4]);
	}
}
