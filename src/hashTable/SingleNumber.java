package hashTable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] A) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	Integer rst = null;
    	if(A == null || A.length == 0){
    		return 0;
    	}
    	
    	for(int i : A){
    		Integer temp = new Integer(i);
    		if(map.get(temp) == null){
    			map.put(temp, 1);
    		}
    		else{
    			map.remove(temp);
    		}
    	}
    	
    	for(Iterator iter = map.keySet().iterator(); iter.hasNext();){
    		  rst = (Integer)iter.next();
    	}

		return (int)rst;	
    }	
}
