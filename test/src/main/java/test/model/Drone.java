package test.model;


import java.util.ArrayList;
import java.util.List;

import test.output.DeliverInstruction;
import test.output.Instruction;
import test.output.LoadInstruction;
import test.utils.Distance;


public class Drone {

    public long              id;
    public List<Instruction> instructions = new ArrayList<>();
    public long              payload      = Grid.payload;
    public long              currentRow;
    public long              currentColumn;

    public Drone(long id ){
    	this.id = id;
    }
    
    public long occupation = 0;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Drone other = (Drone) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    public long getDistance(Warehouse warehouse, Command command) {
        long dist = occupation;
        dist += Distance.distance(currentRow, currentColumn, warehouse.r, warehouse.c);
        dist += Distance.distance(warehouse.r, warehouse.c, command.targetRow, command.targetColumn);
        return Grid.turns <= dist ? Long.MAX_VALUE : dist;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ id >>> 32);
        return result;
    }

    @Override
    public String toString() {
        return "Drone [id=" + id + ", instructions=" + instructions + ", payload=" + payload + ", currentRow="
                + currentRow + ", currentColumn=" + currentColumn + ", occupation=" + occupation + "]";
    }
}
