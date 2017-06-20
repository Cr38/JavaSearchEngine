import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Indexer {
	public Map< String,List<Integer> > index = new HashMap< String,List<Integer> >();
	
	public Indexer(String[] files) {
		parseFiles(files);
	}

	private void parseFiles(String[] files){
		String line = null;
		int docId = 0;
		//read all the files one by one
		for(String file : files){
			try{
				//read the file
				BufferedReader bf = new BufferedReader(new FileReader(file));
				System.out.println("Indexing " + file + " ...");
				docId++;
				
				while((line = bf.readLine()) != null){				
					String[] words = line.split("\\W+");//take only the words
					for(String word : words){
						word = word.toLowerCase();//make all word lower case in the dictionary
						index(word,docId);
					}
				}
				bf.close();
			}catch (FileNotFoundException e) {
				System.out.println("Cant open file "+file);
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error reading file "+file);
				e.printStackTrace();
			}
		}
	}

	private void index(String word, int docId){
		//TODO add position of word
		if(index.get(word) == null){//if word isn't in dictionary
			List<Integer> docs = new ArrayList<Integer>();
			docs.add(docId);
			index.put(word, docs);//add the word in the dictionary
		}else{
			index.get(word).add(docId);//add the document in the list of documents
		}
	}
	
	public Map<String,List<Integer>> sortIndex(){
		return new TreeMap<String, List<Integer> >(index);
	}
}

