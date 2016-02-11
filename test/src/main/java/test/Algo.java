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

    public static void algo() {

        init();

        optimisationCommandOrder(Grid.commands).forEach(command -> resolveCommand(command));
    }

    public static Drone findAvailableDrone() {
//    	long min = Long.MAX_VALUE;
//    	Drone drone = null;
//    	for (Drone drone : Grid.drone_s) {
//    		long dist = drone.getDistance(warehouse, command);
//    		if (drone == null) {
//    			
//    		}
//    	}
//    	Grid.drone_s.stream().map(drone -> new Pair<Drone, Long>(drone, drone.getDistance(warehouse, command)))
//    	.reduce((p1, p2) -> Math.min(p1.second, p2.));
//    	
        Drone res = null;
        long min = Long.MAX_VALUE;
        for (Drone drone : Grid.drone_s) {
            long tmp = drone.occupation;
            if (tmp < min) {
                min = tmp;
                res = drone;
            }
        }
        return res;
    }

    /**
     * return Warehouse to quantity
     */
    public static Pair<Warehouse, Long> findWarehouseFor(Item item, Long quantity) {
        Warehouse warehouse = Grid.warehouses.stream().filter(w -> w.has(item)).findFirst().get();
        long availableQty = warehouse.get(item, quantity);
        return new Pair(warehouse, availableQty);
    }

    public static void init() {
        Grid.drone_s.forEach(d -> d.currentRow = Grid.warehouses.get(0).r);
        Grid.drone_s.forEach(d -> d.currentColumn = Grid.warehouses.get(0).c);
    }

    public static Stream<Command> optimisationCommandOrder(List<Command> commands) {
        // OPTIMISATION POSSIBLE : optimiser l'ordre d'exécution des commandes
        return commands.stream();
    }

    public static void resolveCommand(Command command) {
        System.out.println(command);
        for (Entry<Item, Long> entry : command.itemToQuantity.entrySet()) {
            Item item = entry.getKey();
            Long quantity = entry.getValue();
            System.out.println("       item : " + item.id + ", qty : " + quantity);
            long remainsQty = quantity;
            while (remainsQty > 0) {
                Pair<Warehouse, Long> warehouseToQty = findWarehouseFor(item, quantity);
                System.out
                        .println("       warehouse : " + warehouseToQty.first.id + ", qty : " + warehouseToQty.second);
                sendAllFromWarehouse(warehouseToQty.first, item, warehouseToQty.second, command);
                remainsQty = remainsQty - warehouseToQty.second;
            }
        }
    }

    public static void sendAllFromWarehouse(Warehouse warehouse, Item item, long quantity, Command command) {
        long remainsQty = quantity;
        while (remainsQty > 0) {
            Drone drone = findAvailableDrone();
            long qtyTakeByDrone = drone.deliver(warehouse, item, quantity, command);
            System.out.println("       drone : " + drone.id + ", qty : " + qtyTakeByDrone);
            remainsQty -= qtyTakeByDrone;
        }
    }

}
