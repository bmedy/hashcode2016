/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


public class LoadInstruction extends Instruction {

    public int warehouseID;
    public int productID;
    public int productCount;

    public LoadInstruction() {
        this.type = Instruction.LOAD;
    }

}
