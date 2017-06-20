import java.util.List;

public class Searcher {

	private Indexer indexer;
	
	/*Constructor*/
	public Searcher(Indexer _indexer) {
		this.indexer = _indexer;
	}
	
	public Boolean hasBool(String[] querys){
		for(String query : querys){
			if(query.equals("AND") || query.equals("OR")){
				return true;
			}
		}
		return false;
	}
	
    public List<Integer> search(String query){
			if(indexer.index.get(query) == null){
	    		return null;
			}else{
				return indexer.index.get(query);
			}
	}

	public List<Integer> boolSearch(String[] querys) {
		for(int i=0;i<querys.length;i++){
			if(querys[i].equals("AND")){
				BoolQuery bq = new BoolQuery(search(querys[i-1]),search(querys[i+1]));
				return bq.calcAND(); 
			}else if (querys[i].equals("OR")){
				BoolQuery bq = new BoolQuery(search(querys[i-1]),search(querys[i+1]));
				return bq.calcOR();
			}
			
		}
		return null;
	}

}
