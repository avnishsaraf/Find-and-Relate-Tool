package org.findandrelate.main;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

public class Indexer {

	private File mFile;
	private Map<String, IndexEntry> index = new LinkedHashMap<String, IndexEntry>();

	public Indexer(File inputFile){
		mFile = inputFile;
	}

	public Map<String, IndexEntry> index() throws IOException{
		if(mFile.exists()){
			PDDocument doc = PDDocument.load(mFile);
			for(int j = 1; j <= doc.getNumberOfPages();++j){
				PDFTextStripper stripper = new PDFTextStripper();
				stripper.setStartPage(j);
				stripper.setEndPage(j);
				String content = stripper.getText(doc);
				String[] words = content.replaceAll("[^a-zA-Z ]", "").split(" ");

				for(int i = 0; i <words.length; ++i){
					String word = words[i].trim().toLowerCase();
					if(index.containsKey(word))
						index.get(word).addOccurence(new Position(j, i));
					else
						index.put(word, new IndexEntry(word, new Position(j, i)));	 
				}
			}
			doc.close();
		}
		return index;
	}

}
