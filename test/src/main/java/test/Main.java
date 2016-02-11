package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import test.model.Grid;
import test.output.InstructionWriter;

public class Main {
	
	public static void main(String[] tt) {
		
		Parser.parse();
		Algo.algo();
		
		// output
		Grid.drone_s.stream().forEach(drone -> {InstructionWriter.flush(drone.instructions)});
	}
}
