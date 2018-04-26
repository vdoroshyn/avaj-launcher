package src.simulator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

private static WeatherTower weatherTower = new WeatherTower();

public class Simulator {

	public static void main(String[] args) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null) {
				int numberOfSimulations = Integer.parseInt(line.split(" ")[0]);
				System.out.println(numberOfSimulations);
			}

			while ((line = reader.readLine()) != null) {

				String type = line.split(" ")[0];
				String name = line.split(" ")[1];
				int longitude = Integer.parseInt(line.split(" ")[2]);
				int latitude = Integer.parseInt(line.split(" ")[3]);
				int height = Integer.parseInt(line.split(" ")[4]);
				System.out.println(line);
			}

		} catch (IOException e) {
			System.out.println("huy");
		}
		// Aircraft cessna172 = new Aircraft();
	}
}

// class Aircraft {
// 	int passengers;
// 	int cruiseSpeed;
// 	double fuelCapacity;
// 	double fuelBurnRate;

// 	Aircraft() {
// 		System.out.println("Aircraft is created");
// 	}
// }
