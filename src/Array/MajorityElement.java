package Array;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] num) {
        int mark = num.length/2;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < num.length; i++){
        	if(map.get(num[i]) == null){
        		map.put(num[i],0);
        	}
        	if(map.get(num[i])+1 > mark){
        		return num[i];
        	}
        	else{
        		map.put(num[i],map.get(num[i])+1);
        	}
        }
    	
    	return 0;
    }
}
