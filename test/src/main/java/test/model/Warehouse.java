package test.model;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Warehouse {

	public long id;
	public long r;
	public long c;
	public Map<Item, Long> items = new HashMap<Item, Long>() {
		{
			put(Item.fakeItem(), 10L);
		}
	};


	public Warehouse(long id){
		this.id = id;
	}
	
    public void reduceItemQuantity(Item item, long qty) {
        long availableQty = items.get(item) - qty;
        items.put(item, new Long(availableQty));
    }
    
    public boolean has(Item item) {
    	return items.containsKey(item);
    }
    
    public long get(Item item, long quantity) {
    	Long qtyInW = items.get(item);
    	if (qtyInW != null) {
    		if (qtyInW > quantity) {
    			return quantity;
    		} else {
    			return qtyInW;
    		}
    	}
    	return 0;
    }
    
    @Override
	public String toString() {
		return "Warehouse [id=" + id + ", r=" + r + ", c=" + c + ", items=" + items + "]";
	}
}