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
    	return items.containsKey(item) && items.get(item) > 0;
    }
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Warehouse other = (Warehouse) obj;
		if (id != other.id)
			return false;
		return true;
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