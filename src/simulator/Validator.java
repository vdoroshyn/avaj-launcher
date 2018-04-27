package src.simulator;

class Validator {
	public static void validateLine(String line) {
		String[] splitLine = line.split(" ");
		validateIntegers(splitLine);
	}

	private static void validateIntegers(String[] splitLine) {
		Integer.parseInt(splitLine[2]);
		Integer.parseInt(splitLine[3]);
		Integer.parseInt(splitLine[4]);
	}
}
