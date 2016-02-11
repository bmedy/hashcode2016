/*
 * Copyright (c) 2016 by VIF (Vignon Informatique France)
 * Project : test
 * File : $RCSfile$
 * Created on 11 févr. 2016 by danyl
 */
package test.output;


public abstract class Instruction {

    public final static String LOAD    = "L";
    public final static String DELIVER = "D";
    public final static String WAIT    = "W";

    public long   droneID;
    public String type;

}
