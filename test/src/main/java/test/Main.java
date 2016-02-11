package test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] tt) {
		
		Parser parser = new Parser();
		
		try (BufferedReader br = new BufferedReader(new FileReader("/tmp/example.in")))
		{
			parser.readGrid(br.readLine());
			
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
}
