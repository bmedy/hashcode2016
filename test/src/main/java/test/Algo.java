package test;

import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Stream;

import test.model.Command;
import test.model.Drone;
import test.model.Grid;
import test.model.Item;
import test.model.Warehouse;

public class Algo {

	public static Stream<Command> optimisationCommandOrder(List<Command> commands) {
		// OPTIMISATION POSSIBLE : optimiser l'ordre d'exécution des commandes
		return commands.stream();
	}
	
	public static void algo() {
		optimisationCommandOrder(Grid.commands).forEach(command -> resolveCommand(command));
	}
	
	public static void resolveCommand(Command command) {
		for (Entry<Item, Long> entry : command.itemToQuantity.entrySet()) {
			Item item = entry.getKey();
			Long quantity = entry.getValue();
			long remainsQty = quantity;
			while (remainsQty > 0) {
				Pair<Warehouse, Long> warehouseToQty = findWarehouseFor(item, quantity);
				Drone drone = findAvailableDrone();
				drone.deliver(warehouseToQty.first, item, warehouseToQty.second, command);
				remainsQty = remainsQty - warehouseToQty.second;
			}
		}
	}
	
	public static Drone findAvailableDrone() {
		todo;
	}
	
	/**
	 * return Warehouse to quantity
	 */
	public static Pair<Warehouse, Long> findWarehouseFor(Item item, Long quantity) {
		todo;
	}
	 
}
