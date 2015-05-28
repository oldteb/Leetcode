package string;

import java.util.HashMap;
import java.util.Map;

public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	int i = 0;
        while(n/times(map,i) > 26){
        	i++;
        }
        String s = "";
        int j;
        while(n > 0){
        	if(n%times(map,i)==0 && i != 0){
        		j = n/times(map,i)-1;
        	}
        	else  j = n/times(map,i);
        	s += (char)(j+64);
        	n -= j * times(map,i);
        	i--;
        }
        
        return s; 
    }
    
    int times(Map<Integer,Integer> map, int time){
    	if(map.get(time) == null){
    		int multi = 1;
    		for(int j = 0; j < time; j++){
    			multi *= 26;
    		}
    		map.put(time,multi);
    	}
    	return map.get(time);
    }
}
