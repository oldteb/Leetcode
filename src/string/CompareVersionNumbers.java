package string;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 *
 * 0.1 < 1.1 < 1.2 < 13.37

 * 
 * @author yunhe
 *
 */
public class CompareVersionNumbers {
	
	// RegEx solution
    public int compareVersion1(String version1, String version2) {
        if(version1 == null || version2 == null)  return 0;
        String[] ver1Arr = version1.split("\\.");
        String[] ver2Arr = version2.split("\\.");
        int maxLen = Math.max(ver1Arr.length, ver2Arr.length);
        for(int i = 0; i < maxLen; i++){
            Integer v1 = ( i < ver1Arr.length ? Integer.parseInt(ver1Arr[i]) : 0);
            Integer v2 = ( i < ver2Arr.length ? Integer.parseInt(ver2Arr[i]) : 0);
            if(v1 == v2)  continue;
            else return (v1 > v2 ? 1 : -1);
        }
        return 0;
    }
    
    // naive solution
    public int compareVersion2(String version1, String version2) {
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
