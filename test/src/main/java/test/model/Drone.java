package test.model;


import java.util.ArrayList;
import java.util.List;

import test.output.DeliverInstruction;
import test.output.Instruction;
import test.output.LoadInstruction;


public class Drone {

    public List<Instruction> instructions = new ArrayList<>();

    public void deliver(Warehouse warehouse, Item item, long qty, Command command) {

        warehouse.reduceItemQuantity(item, qty);

        LoadInstruction load = new LoadInstruction(warehouse.id, item.id, qty);
        DeliverInstruction deliver = new DeliverInstruction(command.id, item.id, qty);
        instructions.add(load);
        instructions.add(deliver);

    }
}
