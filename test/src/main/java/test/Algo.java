package test;

import test.model.Command;
import test.model.Grid;

public class Algo {

	public static void algo() {
		Grid.commands.stream().forEach(command -> resolveCommand(command));
	}
	
	public static void resolveCommand(Command command) {
		
	}
	
}
