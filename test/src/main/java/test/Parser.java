package test;

import test.model.Grid;

public class Parser {

	public void readGrid(String line){
		String[] split = line.split("\\s+");
		
		Grid.rows = Integer.valueOf(split[0]);
		Grid.columns = Integer.valueOf(split[1]);
		Grid.drones = Integer.valueOf(split[2]);
		Grid.turns = Integer.valueOf(split[3]);
		Grid.payload = Integer.valueOf(split[4]);
	}

	public void readProductType(String line){
		String[] split = line.split("\\s+");
		
		Grid.rows = Integer.valueOf(split[0]);
		
	}
}
