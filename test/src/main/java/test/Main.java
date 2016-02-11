package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import test.model.Grid;
import test.output.InstructionWriter;

public class Main {
	
	public static void runFile(Path path) {
		Parser.parse(path);
		Algo.algo();
		// output
		Grid.drone_s.stream().forEach(drone -> InstructionWriter.flush(drone.instructions));
	}
	
	public static void main(String[] tt) {
		runFile(Paths.get("busy_day.in"));
		runFile(Paths.get("mother_of_all_warehouses.in"));
		runFile(Paths.get("redundancy.in"));
	}
}
