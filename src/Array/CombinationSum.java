package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	if(candidates == null || candidates.length == 0){
    		return rst;
    	}	
    	int cur_sum = 0;
    	int level = 0;
    	
    	candidates = removeDuplicates(candidates);
    	Arrays.sort(candidates);
    	int[] times = new int[candidates.length];
    	
    	while(cur_sum <= target){
    		help(candidates, cur_sum, 1, target, times, rst);
    		times[level]++;
    		cur_sum += candidates[level];
    	}
    	
		return rst; 
    }
    
    void help(int[] candidates, int cur_sum, int level, int target, int[] times, List<List<Integer>> rst){
    	if(level == candidates.length){
    		if(cur_sum == target){
    			//add...
    			ArrayList<Integer> temp = new ArrayList<Integer>();
    			for(int i = 0; i < candidates.length ; i++){
    				for(int j = 0; j < times[i]; j++){
    					temp.add(candidates[i]);
    				}
    			}
    			rst.add(temp);
    		}
    		return;
    	}
    	times[level] = 0;
    	while(cur_sum <= target){
    		help(candidates, cur_sum, level+1, target, times, rst);
    		times[level]++;
    		cur_sum += candidates[level];
    	}
    }
    
    public static int[] removeDuplicates(int []s){
        int result[] = new int[s.length], j=0;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i : s) {
            if(map.containsKey(i)){
            	continue;
            }
            result[j++] = i;
            map.put(i, 1);
        }
        
        int[] trst = new int[j];
        for(int k = 0; k < j; k++){
        	trst[k] = result[k];
        }
        
        return trst;
    }
    
    
    
    public static void main(String argv[]){
    	CombinationSum cs = new CombinationSum();
    	int[] buf = {2,3,6,7,10,14,20};
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	rst = cs.combinationSum(buf, 29);
    	
    	while(rst.size() != 0){
    		List<Integer> temp = rst.get(0);
    		while(temp.size() != 0){
    			System.out.print(temp.get(0)+ ",");
    			temp.remove(0);
    		}
    		System.out.println();
    		rst.remove(0);
    	}
    }
    
	
}
