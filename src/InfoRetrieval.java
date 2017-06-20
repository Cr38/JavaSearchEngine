
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InfoRetrieval {

	public static void main(String[] args) {
		
		/*Index the given files*/
		Indexer indexer = new Indexer(args);
		
		/*Sort the inverted index*/
		indexer.index = indexer.sortIndex();
		
		/*Search*/
		System.out.print("Search:");
		
		Searcher searcher = new Searcher(indexer);
		
		/*Read querys from user*/
		Scanner s = new Scanner(System.in);
		String[] querys = s.nextLine().split("\\W+");
		s.close();
			
		/*Convert querys to lower case*/
		for(int i=0;i<querys.length;i++){
			if(!(querys[i].equals("AND") || querys[i].equals("OR")))
				querys[i] = querys[i].toLowerCase();
		}
		/*Simple search or with boolean*/
		List<Integer> answer = new ArrayList<Integer>();
		if(searcher.hasBool(querys)){
			answer = searcher.boolSearch(querys);
			for(String query : querys){
				System.out.print(query + " ");
			}
			System.out.print(":" + answer);
		}else{
			for(String query : querys){
				answer = searcher.search(query);
				if(answer == null){
					System.out.println("Word " + "'" + query + "' " + "not found!");
				}else{
					System.out.println(query + ":" + answer);
				}
			}
		}


		
	}
	
}
