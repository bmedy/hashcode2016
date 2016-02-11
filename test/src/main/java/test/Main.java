package test;


import java.io.IOException;

import test.model.Grid;
import test.output.InstructionWriter;

public class Main {
	
	public static void runFile(String path) {
		try {
			Parser.parse(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// print grid
		Grid.print();
		// algo
		System.out.println("ALGO");
		Algo.algo();
		// output
		Grid.drone_s.stream().forEach(drone -> InstructionWriter.flush(drone.instructions));
	}
	
	public static void main(String[] tt) {
		runFile("example.in");
		//runFile("busy_day.in");
		//runFile(Paths.get("mother_of_all_warehouses.in"));
		//runFile(Paths.get("redundancy.in"));
	}
}
