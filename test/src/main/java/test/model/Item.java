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
	public String toString() {
		return "Item [id=" + id + ", weigth=" + weigth + "]";
	}
}
