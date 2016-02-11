package test.model;


import java.util.Map;


public class Command {
    public long            id;
    public Map<Item, Long> itemToQuantity;
    public long            targetRow;
    public long            targetColumn;
}
