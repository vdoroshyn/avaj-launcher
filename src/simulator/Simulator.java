package src.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import src.simulator.WeatherTower;
import src.exceptions.TestException;

public class Simulator {

	private static WeatherTower weatherTower = new WeatherTower();

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null) {
				int numberOfSimulations = Integer.parseInt(line.split(" ")[0]);
				System.out.println(numberOfSimulations);
				if (numberOfSimulations != 25) {
					throw (new TestException("Invalid number of simulations"));
				}
			} else {
				throw (new TestException("The file is empty"));
			}

			while ((line = reader.readLine()) != null) {
				Validator.validateLine(line);
				// String type = line.split(" ")[0];
				// String name = line.split(" ")[1];
				// int longitude = Integer.parseInt(line.split(" ")[2]);
				// int latitude = Integer.parseInt(line.split(" ")[3]);
				// int height = Integer.parseInt(line.split(" ")[4]);
				System.out.println(line);
			}
			// weatherTower.conditionsChanged();

		} catch (TestException e) {
			System.out.println(e.getMessage());
		} catch (FileNotFoundException e) {
			System.out.println("Couldn't find the file " + args[0]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Are you tring to get a segmentation fault?");
		} catch (IOException e) {
			System.out.println("There was an error while reading the file " + args[0]);
		}
	}
}

/*

1)  Read the file and the number of iterations on the first line. 
	If there is a problem with it, throw an exception
2)  Read the rest of the file line by line validating each line.
	Every valid line is created as a respective object in observers arraylist and registered.
	Throw an exception in case something is wrong and put "" into the result file.
3)  For each iteration weatherTower.changeWeather() is called.
	changeWeather() -> conditionsChanged() -> iterate through the arraylist of observers ->
	updateConditions() -> getWeather() -> getCurrentWeather()
	log changes into the result file
	unregister an observer if its height is 0
*/
