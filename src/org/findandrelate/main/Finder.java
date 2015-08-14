package org.findandrelate.main;

import java.io.FileNotFoundException;
import java.util.Map;

import edu.smu.tspell.wordnet.WordNetDatabase;

public class Finder {
	
	private Map<String, IndexEntry> index;
	private WordNetDatabase database;
	
	public Finder (Map<String, IndexEntry> index) throws FileNotFoundException{
		this.index = index;
		
		System.setProperty("wordnet.database.dir", "C:\\Users\\VAIO\\Downloads\\WordNet-3.0\\dict" );
		database = WordNetDatabase.getFileInstance();
		
	}
	
	public void find(String word){
		String[] synonyms = database.getSynsets(word)[0].getWordForms();
		
		for(String synonym:synonyms){
			if(index.containsKey(synonym)){
				index.get(synonym).print();
			}
		}
	}

	
}
