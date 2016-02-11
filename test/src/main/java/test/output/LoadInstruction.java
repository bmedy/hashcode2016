/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


public class LoadInstruction extends Instruction {

    public long warehouseID;
    public long productID;
    public long productCount;

    public LoadInstruction() {
        this.type = Instruction.LOAD;
    }

    public LoadInstruction(long warehouseID, long productID, long productCount) {
        this.type = Instruction.LOAD;
        this.warehouseID = warehouseID;
        this.productID = productID;
        this.productCount = productCount;
    }

}
