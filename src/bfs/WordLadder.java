package bfs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
    	if(start == end || start == null || end == null)  return 0;
        int lvl = 2;
        List<String> queue = new ArrayList<String>();
        HashSet<String> log = new HashSet<String>();
        queue.add(start);
        log.add(start);
        
        while(queue.isEmpty() == false){
        	int c = queue.size();
        	for(int i = 0; i < c; i++){
                if(strdef(queue.get(0),end) == 1)  return lvl;
//        		for( String s : dict){
//        			if(strdef(queue.get(0),s) == 1 && log.contains(s) == false){
//        				queue.add(s);
//        				log.add(s);
//        			}
//        		}
                char[] temp = queue.get(0).toCharArray();
                for(int m = 0; m < temp.length ; m++){
                	char cc = temp[m];
                	for(char n = 'a'; n < 'z'; n++){
                		if(n == cc)  continue;
                		temp[m] = n;
                		if(dict.contains(new String(temp)) == true && log.contains(new String(temp)) == false){
                			queue.add(new String(temp));
                			log.add(new String(temp));
                		}
                	}
                	temp[m] = cc;
                }
        		queue.remove(0);
        	}
        	lvl++;
        }

        return 0;
        
    }
    
    
    int strdef(String s1, String s2){
    	if(s1.length() != s2.length())  return -1;
    	int count = 0;
    	for(int i = 0; i < s1.length() && count < 2; i++){
    		if(s1.charAt(i) != s2.charAt(i)){
    			count++;
    		}
    	}
    	if(count == 1)  return 1;
    	else return 0;
    }
    
    
    
    public static void main(String argv[]){
    	WordLadder wd = new WordLadder();
    	Set<String> s = new HashSet<String>();
    	s.add("hot");  s.add("dog");  s.add("dot");
    	
    	System.out.println(wd.ladderLength("hot", "dog", s));
    }
}
