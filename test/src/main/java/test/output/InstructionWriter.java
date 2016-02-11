/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class InstructionWriter {

    public static void flush(List<Instruction> instructions) throws IOException {
    	try {

        List<String> output = new ArrayList<>();
        DeliverInstruction deliver;
        LoadInstruction load;
        WaitInstruction wait;

        for (Instruction inst : instructions) {

            if (inst.type.equals(Instruction.DELIVER)) {
                deliver = (DeliverInstruction) inst;
                output.add(inst.droneID + "D" + deliver.orderID + deliver.productID + deliver.productCount);
            } else if (inst.type.equals(Instruction.LOAD)) {
                load = (LoadInstruction) inst;
                output.add(inst.droneID + "L" + load.warehouseID + load.productID + load.productCount);
            } else if (inst.type.equals(Instruction.WAIT)) {
                wait = (WaitInstruction) inst;
                output.add(inst.droneID + "W" + wait.turnCount);
            }
        }

        String outFilePath = "/tmp/file.out";
        Files.write(Paths.get(outFilePath), output);
    	} catch(Exception e) {
    		e.printStackTrace();
    	}

    }

}
