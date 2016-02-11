/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


public class WaitInstruction extends Instruction {

    public int turnCount;

    public WaitInstruction() {
        this.type = Instruction.WAIT;
    }

}
