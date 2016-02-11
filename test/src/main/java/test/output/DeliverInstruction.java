/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


public class DeliverInstruction extends Instruction {

    public int orderID;
    public int productID;
    public int productCount;

    public DeliverInstruction() {
        this.type = Instruction.DELIVER;
    }
}
