package string;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
        if(s == null){
        	return 0;
        }
        else if(s.length() == 0){
        	return 0;
        }
        int sum = 0;
        StringBuffer sb = new StringBuffer(s);
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        while(sb.length() != 0){
        	int d = sb.charAt(0) - 64;
        	sum += d*times(map, sb.length()-1);
        	sb.deleteCharAt(0);
        }
        
        return sum;
    }
    
    int times(Map<Integer,Integer> map, int time){
    	if(map.get(time) == null){
    		int multi = 1;
    		for(int i = 0; i < time; i++){
    			multi *= 26;
    		}
    		map.put(time, multi);
    	}
    	
    	return map.get(time);	
    }
    
    
}
