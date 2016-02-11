package test.model;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	public static void print() {
		System.out.println("Grid :");
		System.out.println("    rows : "+rows);
		System.out.println("    columns : "+columns);
		System.out.println("    drones : "+drones);
		System.out.println("    turns : "+turns);
		System.out.println("    payload : "+payload);
		System.out.println("    commands : " + Arrays.toString(commands.toArray()));
		System.out.println("    drone_s : " + Arrays.toString(drone_s.toArray()));
		System.out.println("    warehouses : " + Arrays.toString(warehouses.toArray()));
		System.out.println("    items : " + Arrays.toString(items.toArray()));
	}
	
}

