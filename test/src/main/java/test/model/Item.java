package test.model;


public class Item {

	public Item(long id){
		this.id = id;
	}
	
	public long    id;
 	public Integer weigth;
 	
 	private static Item fakeItem;
 	
 	public static Item fakeItem() {
 		if (fakeItem == null) {
 			fakeItem = new Item(0);
 			fakeItem.weigth = 10;
 		}
 		return fakeItem;
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
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", weigth=" + weigth + "]";
	}
}
