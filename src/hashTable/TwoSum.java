package hashTable;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class TwoSum {
	
    public int[] twoSum(int[] numbers, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] index = new int[2];
		
		if(numbers.length < 2){
			return index;
		}
		
		for(int i = 0; i< numbers.length ; i++){
			int key = target - numbers[i];
			int value = i;
			map.put(key, value);
		}
		
		for(int i = 0; i< numbers.length ; i++){
			if(map.get(numbers[i]) != null){
				int id1 = i;
				int id2 = map.get(numbers[i]);
				if(id1 == id2)
					continue;

				index[0] = id1+1;
				index[1] = id2+1;
				
				break;
			}
		}
		
    	return index;
    }
    
    public static void main(String argv[]){
    	int[] a = {3,2,4};
    	
    	TwoSum ts = new TwoSum();
    	
    	int[] b = ts.twoSum(a, 6);
    	
    	System.out.println(b[0] + " and " + b[1]);

    }
	
	
	
}
