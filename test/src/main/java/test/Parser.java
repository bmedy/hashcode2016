package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import test.model.Command;
import test.model.Grid;
import test.model.Item;
import test.model.Warehouse;

public class Parser {

	public static void parse(String path) throws IOException{
		
		List<String> lines = Files.readAllLines(Paths.get("src/main/resources/" + path));
		Iterator<String> it = lines.stream().iterator();
	
		// line 1
	
		String dataLine = it.next();
		System.out.println(dataLine);
		String[] line = dataLine.split("\\s+");
		Grid.rows = Integer.valueOf(line[0]);
		Grid.columns = Integer.valueOf(line[1]);
		Grid.drones = Integer.valueOf(line[2]);
		Grid.turns = Integer.valueOf(line[3]);
		Grid.payload = Integer.valueOf(line[4]);
		
		// line 2

		dataLine = it.next();
		System.out.println(dataLine);
		Grid.items = new ArrayList<>();
		for(int i = 0; i < Integer.valueOf(dataLine); i++){
			Grid.items.add(new Item(i));
		}
		
		// line 3
		dataLine = it.next();
		System.out.println(dataLine);
		line = dataLine.split("\\s+");
		for(int i = 0; i < line.length; i++){
			Grid.items.get(i).weigth = Integer.valueOf(line[i]);
		}
		System.out.println("items:"+Grid.items.size());
		
		// line 4
		dataLine = it.next();
		System.out.println(dataLine);
		Grid.warehouses = new ArrayList<>();
		for(int i = 0; i < Integer.valueOf(dataLine); i++){
			String location = it.next();
			
			line = location.split("\\s+");
			Warehouse w = new Warehouse(i);
			w.items = new HashMap<>();
			w.r = Integer.valueOf(line[0]);
			w.c = Integer.valueOf(line[1]);
			
			String quantities = it.next();
			
			line = quantities.split("\\s+");
			for(int j = 0; j < line.length; j++){
				System.out.println("j"+j);
				Item key = Grid.items.get(j);
				Long valueOf = Long.valueOf(line[j]);
				System.out.println(key);
				System.out.println(valueOf);
				w.items.put(key,valueOf);	
			}
			Grid.warehouses.add(w);
		}
		
		dataLine = it.next();
		System.out.println(dataLine);
		int nbCommands = Integer.valueOf(dataLine);
		Grid.commands = new ArrayList<>();
		for(int i = 0; i < nbCommands; i++){
			dataLine = it.next();
			line = dataLine.split("\\s+");
			Command c = new Command();
			c.id = i;
			c.targetRow = Long.valueOf(line[0]);
			c.targetColumn = Long.valueOf(line[1]);
			
			dataLine = it.next();
			
			Long quantityCmd = Long.valueOf(dataLine);
			dataLine = it.next();
			line = dataLine.split("\\s+");
			for(int k = 0; k < line.length; k++){
				Item key = Grid.items.get(Integer.valueOf(line[k]));
				if(!c.itemToQuantity.containsKey(key)){
					c.itemToQuantity.put(key, 0L);
				}
				c.itemToQuantity.put(key, c.itemToQuantity.get(key)+1);
			}
			
			Grid.commands.add(c);
		}
		
		System.out.println("end");
			
	}
}
