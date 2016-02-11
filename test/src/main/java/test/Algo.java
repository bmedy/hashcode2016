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
				sendAllFromWarehouse(warehouseToQty.first, item, warehouseToQty.second, command);
				remainsQty = remainsQty - warehouseToQty.second;
			}
		}
	}
	
	public static void sendAllFromWarehouse(Warehouse warehouse, Item item, long quantity, Command command) {
		long remainsQty = quantity;
		while(remainsQty > 0) {
			Drone drone = findAvailableDrone();
			long qtyTakeByDrone = drone.deliver(warehouse, item, quantity, command);
			remainsQty -= qtyTakeByDrone;
		}
	}
	
	public static Drone findAvailableDrone() {
		return Grid.drone_s.get(0);
	}
	
	/**
	 * return Warehouse to quantity
	 */
	public static Pair<Warehouse, Long> findWarehouseFor(Item item, Long quantity) {
		Warehouse warehouse = Grid.warehouses.stream().filter(w -> w.has(item)).findFirst().get();
		long availableQty = warehouse.get(item, quantity);
		return new Pair(warehouse, availableQty);
	}
	 
}
