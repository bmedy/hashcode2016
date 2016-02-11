package test;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import test.model.Grid;
import test.output.Instruction;
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
		System.out.println();
		System.out.println();
		System.out.println("ALGO");
		try {
			Algo.algo();
		} catch(RuntimeException e) {
			System.out.println(e);
		}
		System.out.println();
		System.out.println();
		System.out.println();
		// output
		Optional<List<Instruction>> t = Grid.drone_s.stream()// 
		.map(drone -> drone.instructions) //
		.reduce((i1, i2) -> {i1.addAll(i2);return i1;});
		InstructionWriter.flush(t.get());
	}
	
	public static void main(String[] tt) {
		runFile("busy_day.in");
		//runFile("busy_day.in");
		//runFile(Paths.get("mother_of_all_warehouses.in"));
		//runFile(Paths.get("redundancy.in"));
	}
}
