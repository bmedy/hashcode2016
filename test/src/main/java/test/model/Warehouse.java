package test.model;


import java.util.Map;


public class Warehouse {

	public long id;
	public long r;
	public long c;
	public Map<Item, Long> items;


	public Warehouse(long id){
		this.id = id;
	}
	
    public void reduceItemQuantity(Item item, long qty) {
        long availableQty = items.get(item) - qty;
        items.put(item, new Long(availableQty));
    }
}