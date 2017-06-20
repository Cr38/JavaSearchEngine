import java.util.ArrayList;
import java.util.List;

public class BoolQuery {
	private List<Integer> list1;
	private List<Integer> list2;
	
	public BoolQuery(List<Integer> list1, List<Integer> list2) {
		super();
		this.list1 = list1;
		this.list2 = list2;
	}

	public List<Integer> calcAND(){
		int i = 0,j = 0;
		List<Integer> answer = new ArrayList<Integer>();
 		while(i < list1.size() && j < list2.size()){
			if(list1.get(i) == list2.get(j)){
				answer.add(list1.get(i));
				i++;
				j++;
			}else{
				if(i < j){
					i++;
				}else{
					j++;
				}
			}
		}
		return answer;
	}
	
	public List<Integer> calcOR(){
		int i=0,j=0;
		List<Integer> answer = new ArrayList<Integer>();
		while(i< list1.size() && j < list2.size()){
			if(list1.get(i) == list2.get(j)){
				answer.add(list1.get(i));
			}else{
				answer.add(list1.get(i));
				answer.add(list2.get(j));
			}
			i++;
			j++;
		}
		return answer;
	}
}
