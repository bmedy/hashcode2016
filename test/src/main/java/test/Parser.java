package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import test.model.Grid;
import test.model.Item;
import test.model.Warehouse;

public class Parser {

	public static void parse(){
		
		try (BufferedReader br = new BufferedReader(new FileReader("/tmp/example.in")))
		{
			// line 1
			String[] line = br.readLine().split("\\s+");
			Grid.rows = Integer.valueOf(line[0]);
			Grid.columns = Integer.valueOf(line[1]);
			Grid.drones = Integer.valueOf(line[2]);
			Grid.turns = Integer.valueOf(line[3]);
			Grid.payload = Integer.valueOf(line[4]);
			
			// line 2
			Grid.items = new ArrayList<>();
			for(int i = 0; i < Integer.valueOf(br.readLine()); i++){
				Grid.items.add(new Item(i));
			}
			
			// line 3
			line = br.readLine().split("\\s+");
			Grid.items.get(0).weigth = Integer.valueOf(line[0]);
			Grid.items.get(1).weigth = Integer.valueOf(line[1]);
			Grid.items.get(2).weigth = Integer.valueOf(line[2]);
			
			// line 4
			Grid.warehouses = new ArrayList<>();
			for(int i = 0; i < Integer.valueOf(br.readLine()); i++){
				Grid.warehouses.add(new Warehouse(i));
			}
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
