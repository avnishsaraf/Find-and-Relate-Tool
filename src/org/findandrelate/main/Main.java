package org.findandrelate.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;



public class Main {
	public static void main(String [] args){


		System.out.println("Enter word:");
		Scanner sc = new Scanner(System.in);
		
		File file = new File("C:\\Users\\VAIO\\Desktop\\test.pdf");
		Indexer indexer = new Indexer(file);
		try {
			Finder finder = new Finder(indexer.index());
			finder.find(sc.nextLine());
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
