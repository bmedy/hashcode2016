package test.model;


import java.util.ArrayList;
import java.util.List;

import test.output.DeliverInstruction;
import test.output.Instruction;
import test.output.LoadInstruction;
import test.utils.Distance;


public class Drone {

	public long id;
    public List<Instruction> instructions = new ArrayList<>();
    public long              payload;
    public long              currentRow;
    public long              currentColumn;
    public long              occupation   = 0;

    public long deliver(Warehouse warehouse, Item item, long qty, Command command) {

        long deliveredItemCount = payload / item.weigth;
        deliveredItemCount = deliveredItemCount < qty ? deliveredItemCount : qty;
        warehouse.reduceItemQuantity(item, deliveredItemCount);

        occupation++;
        occupation += Distance.distance(currentRow, currentColumn, warehouse.r, warehouse.c);
        LoadInstruction load = new LoadInstruction(warehouse.id, item.id, deliveredItemCount);
        instructions.add(load);

        currentRow = warehouse.r;
        currentColumn = warehouse.c;

        // Deliver
        occupation += 1;
        occupation += Distance.distance(currentRow, currentColumn, command.targetRow, command.targetColumn);
        DeliverInstruction deliver = new DeliverInstruction(command.id, item.id, deliveredItemCount);
        instructions.add(deliver);

        currentRow = command.targetRow;
        currentColumn = command.targetColumn;

        return deliveredItemCount;

    }
    
    private static Drone fakeDrone;
    
    public static Drone fakeDrone() {
    	if (fakeDrone == null) {
    		fakeDrone = new Drone();
    		fakeDrone.id = 0;
    	}
    	return fakeDrone;
    }
}
