package test.model;


import java.util.Map;


public class Warehouse {

    public int             r;
    public int             c;
    public Map<Item, Long> items;

    public void reduceItemQuantity(Item item, long qty) {
        long availableQty = items.get(item) - qty;
        items.put(item, new Long(availableQty));
    }
}
