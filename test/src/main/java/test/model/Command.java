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
        	itemToQuantity.put(Item.fakeItem(), 10L);
        	fakeCommand = new Command(0, itemToQuantity, 10, 10);	
    	}
    	return fakeCommand;
    }
}
