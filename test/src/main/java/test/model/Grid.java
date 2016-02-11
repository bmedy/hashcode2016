package test.model;

import java.util.ArrayList;
import java.util.List;

public class Grid {
	public static List<Command> commands = new ArrayList<Command>() {
		{
			add(Command.fakeCommand());
		}
	};
	public static List<Drone> drone_s = new ArrayList<Drone>() {{
		add(Drone.fakeDrone());
	}};
	public static List<Warehouse> warehouses = new ArrayList<>();
	public static List<Item> items = new ArrayList<>();
	public static int rows;
	public static int columns;
	public static int drones;
	public static int turns;
	public static int payload;
	
}
