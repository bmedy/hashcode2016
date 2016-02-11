package test.model;


import java.util.HashMap;
import java.util.Map;


public class Command {
    public long            id;
    public Map<Item, Long> itemToQuantity;
    public long            targetRow;
    public long            targetColumn;
    
	public Command(long id, Map<Item, Long> itemToQuantity, long targetRow, long targetColumn) {
		super();
		this.id = id;
		this.itemToQuantity = itemToQuantity;
		this.targetRow = targetRow;
		this.targetColumn = targetColumn;
	}
    
	private static Command fakeCommand = null;
	
    public static Command fakeCommand() {
    	if (fakeCommand == null) {
        	Map<Item, Long> itemToQuantity = new HashMap<>();
        	itemToQuantity.put(Item.fakeItem(), 3L);
        	fakeCommand = new Command(0, itemToQuantity, 10, 10);	
    	}
    	return fakeCommand;
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
		Command other = (Command) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Command [id=" + id + ", itemToQuantity=" + itemToQuantity + ", targetRow=" + targetRow
				+ ", targetColumn=" + targetColumn + "]";
	}
}
