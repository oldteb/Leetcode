package hashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public List<String> anagrams(String[] strs) {
    	if(strs == null || strs.length == 0){
    		return null;
    	}
    	
    	List<String> rst = new ArrayList<String>();
    	Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    	for(int i = 0; i < strs.length; i++){
    		String str = strs[i];
    		char[] chars = str.toCharArray();
    		Arrays.sort(chars);
    		str = new String(chars);
    		if(map.get(str) == null){
    			map.put(str,new ArrayList<Integer>());
    			map.get(str).add(i);
    		}
    		else{
    			if(map.get(str).size() == 1){
    				rst.add(strs[map.get(str).get(0)]);
    				map.get(str).add(i);
    				rst.add(strs[i]);
    			}
    			else{
    				rst.add(strs[i]);
    			}
    		}	
    	}
    	
		return rst;
    }
    
    public static void main(String argv[]){
    	
    	String[] strs = {"abac","cbaa", "cbba", "acba"};
    	Anagrams ana = new Anagrams();
    	List<String> list = ana.anagrams(strs);
    	for(String s : list){
    		System.out.println(s);
    	}
    }
}
