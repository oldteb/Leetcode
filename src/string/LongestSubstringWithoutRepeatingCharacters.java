package string;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null){
        	return 0;
        }
        int max_len = 0;
        int j;
        int bot = 0;
        Map<String,Integer> map = new HashMap<String,Integer>();
    	
    	for(int i = 0; i < s.length(); i++){
    		if(map.get(String.valueOf(s.charAt(i))) == null){
    			map.put(String.valueOf(s.charAt(i)), new Integer(i));
    		}
    		else{
    			max_len = Math.max(max_len, map.size());
    			for(j = bot; j < map.get(String.valueOf(s.charAt(i))); j++){
    				map.remove(String.valueOf(s.charAt(j)));
    			}
    			map.remove(String.valueOf(s.charAt(i)));
    			bot = j+1;
    			map.put(String.valueOf(s.charAt(i)), new Integer(i));
    		}
    	}
    	
    	max_len = Math.max(max_len, map.size());
	
    	return max_len;
    }
    
    public static void main(String argv[]){
    	LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
    	System.out.println(lswrc.lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
    	//System.out.println(lswrc.lengthOfLongestSubstring(""));
    }
}
