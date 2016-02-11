package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
			Grid.items.get(0).weigth = Integer.valueOf(line[0]);
			Grid.items.get(1).weigth = Integer.valueOf(line[1]);
			Grid.items.get(2).weigth = Integer.valueOf(line[2]);
			
			// line 4
			dataLine = it.next();
			System.out.println(dataLine);
			Grid.warehouses = new ArrayList<>();
			for(int i = 0; i < Integer.valueOf(dataLine); i++){
				String location = it.next();
				
				line = location.split("\\s+");
				Warehouse w = new Warehouse(i);
				w.r = Integer.valueOf(line[0]);
				w.c = Integer.valueOf(line[1]);
				// TODO quantity
				Grid.warehouses.add(w);
			}
			
	}
}
