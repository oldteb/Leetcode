package string;

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        List<Integer> v1 = new ArrayList<Integer>();
        List<Integer> v2 = new ArrayList<Integer>();
        convert(v1,version1);
        convert(v2,version2);
        for(int i = 0;;i++){
        	if(i>=v1.size() && i>=v2.size())  return 0;
        	else if(i>=v1.size()){
        		if(v2.get(i) == 0){
        			continue;
        		}
        		else{
        			return -1;
        		}
        	}
        	else if(i>=v2.size()){
        		if(v1.get(i) == 0){
        			continue; 
        		}
        		else{
        			return -1;
        		}
        	}
        	else if(v1.get(i) > v2.get(i)){
        		return 1;
        	}
        	else if(v1.get(i) < v2.get(i)){
        		return -1;
        	}
        }
        
        
    }
    
    void convert(List list, String version){
    	for(int i = 0, j = i; i < version.length(); i = j+1, j = i){
    		while(j < version.length() && version.charAt(j) != '.'){
    			j++;
    		}
    		list.add(Integer.parseInt(version.substring(i, j)));
    	}
    }
	
}
