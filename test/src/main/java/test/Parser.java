package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import test.model.Grid;

public class Parser {

	public static void parse(){
		
		try (BufferedReader br = new BufferedReader(new FileReader("/tmp/example.in")))
		{
			String[] staticInfos = br.readLine().split("\\s+");
			
			Grid.rows = Integer.valueOf(staticInfos[0]);
			Grid.columns = Integer.valueOf(staticInfos[1]);
			Grid.drones = Integer.valueOf(staticInfos[2]);
			Grid.turns = Integer.valueOf(staticInfos[3]);
			Grid.payload = Integer.valueOf(staticInfos[4]);
			
			Grid.productTypeCount = Integer.valueOf(br.readLine());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
