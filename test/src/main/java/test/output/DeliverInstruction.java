/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


public class DeliverInstruction extends Instruction {

    public long orderID;
    public long productID;
    public long productCount;

    public DeliverInstruction() {
        this.type = Instruction.DELIVER;
    }

    public DeliverInstruction(long orderID, long productID, long productCount) {
        this.type = Instruction.DELIVER;
        this.orderID = orderID;
        this.productID = productID;
        this.productCount = productCount;
    }
}
