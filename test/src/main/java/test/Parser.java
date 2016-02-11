package test;

import java.util.List;

import test.model.Grid;

public class Parser {

	public void readGrid(String line){
		String[] split = line.split("\\s+");
		Grid.rows = Integer.valueOf(split[0]);
	}
}
