package org.findandrelate.main;

public class Position{
	private int mPgNum;
	private int mWordNum;
	
	public Position(int pgNum, int wordNum){
		this.mPgNum = pgNum;
		this.mWordNum = wordNum;
	}
	
	public void printPos(){
		System.out.println("Page: "+mPgNum+" Word: "+ ++mWordNum);
	}
}