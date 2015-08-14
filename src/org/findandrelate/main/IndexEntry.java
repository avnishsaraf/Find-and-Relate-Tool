package org.findandrelate.main;

import java.util.ArrayList;

public class IndexEntry {
	

	private String mWord;
	private int mCount = 0;
	private ArrayList<Position> occurence = new ArrayList<Position>();
	
	public IndexEntry(String word, Position pos){
		mWord = word;
		occurence.add(pos);
		++mCount;
	}
	
	public void addOccurence(Position pos){
		occurence.add(pos);
		++mCount;
	}
	
	public void print(){
		System.out.println(mWord+ " was found at:");
		for(int i = 0; i < occurence.size(); ++i)
			occurence.get(i).printPos();
	}
}
