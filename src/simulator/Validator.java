package src.simulator;

import src.exceptions.TestException;

class Validator {
	public static void validateLine(String line) throws TestException {
		String[] splitLine = line.split(" ");
		validateType(splitLine[0]);
		validateName(splitLine[1]);
		validateCoordinates(splitLine);
	}

	private static void validateType(String type) throws TestException {
		if (!"Baloon".equals(type)     &&
			!"Helicopter".equals(type) &&
			!"JetPlane".equals(type))
		{
			throw (new TestException("The type is not valid"));
		}
	}

	private static void validateName(String name) {
		if (name == null || name.isEmpty()) {
			System.out.println("empty string");
		}
	}

	private static void validateCoordinates(String[] coordinates) {
		// try {
			Integer.parseInt(coordinates[2]);
			Integer.parseInt(coordinates[3]);
			Integer.parseInt(coordinates[4]);
		// } catch (NumberFormatException e) {
		// 	throw new RuntimeException();
		// }
	}
}
