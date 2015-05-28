package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        if(num == null){
        	return null;
        }
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(num.length == 0){
        	return rst;
        }
        Arrays.sort(num);
        HashSet<List<Integer>> hs = new HashSet<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        help(num, 1, 0, 0, list, hs, target);
        for(Iterator<List<Integer>> iter = hs.iterator(); iter.hasNext(); ){
        	rst.add(iter.next());
        }
    	
    	return rst;
    }
    
    void help(int[] num, int len, int bgn, int sum, List<Integer> list, HashSet<List<Integer>> hs, int target){
    	int i = 0;
    	list.add(len-1,0);
    	for(i = bgn; i < num.length; i++){
    		if(sum + num[i] == target){
    			List<Integer> temp = new ArrayList<Integer>();
    			list.set(len-1, num[i]);
    			for(Iterator<Integer> iter = list.iterator(); iter.hasNext(); ){
    				temp.add(iter.next());
    			}
    			hs.add(temp);
    			break;
    		}
    		else if(sum + num[i] > target){
    			break;
    		}
    		list.set(len-1, num[i]);
    		help(num, len+1, i+1, sum+num[i], list, hs, target);
    	}
    	list.remove(len-1);
    }
    
    public static void main(String argv[]){
    		
    	CombinationSum2 cs2 = new CombinationSum2();
    	int[] num = {8,1,7,4,4,3};
    	List<List<Integer>> rst = cs2.combinationSum2(num, 8);
    	
    	rst.iterator();
    	for(Iterator<List<Integer>> iter = rst.iterator(); iter.hasNext();){
    		List<Integer> list = iter.next();
    		System.out.print("[");
    		for(Integer i : list){
    			System.out.print(i+",");
    		}
    		System.out.print("]");
    		System.out.println();
    	} 	
    	
    }
}
