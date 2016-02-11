package test.model;


import java.util.ArrayList;
import java.util.List;

import test.output.DeliverInstruction;
import test.output.Instruction;
import test.output.LoadInstruction;
import test.utils.Distance;


public class Drone {

    public List<Instruction> instructions = new ArrayList<>();
    public long              payload;
    public long              currentRow;
    public long              currentColumn;
    public long              occupation;

    public long deliver(Warehouse warehouse, Item item, long qty, Command command) {

        long deliveredItemCount = payload / item.weigth;
        deliveredItemCount = deliveredItemCount < qty ? deliveredItemCount : qty;
        warehouse.reduceItemQuantity(item, deliveredItemCount);

        LoadInstruction load = new LoadInstruction(warehouse.id, item.id, deliveredItemCount);
        DeliverInstruction deliver = new DeliverInstruction(command.id, item.id, deliveredItemCount);
        instructions.add(load);
        instructions.add(deliver);

        // TODO : calculer le nombre de tours pour faire tout ca
        occupation += 1;
        occupation += Distance.distance(currentRow, currentColumn, warehouse.r, warehouse.c);

        return qty - deliveredItemCount;

    }
}
