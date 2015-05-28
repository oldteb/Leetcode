package backtrack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(n < k || n <= 0 || k <= 0){
        	return rst;
        }
        List<Integer> list = new ArrayList<Integer>();
        help(list, 1, 1, rst, n, k);
        
        return rst;
    }
    
    void help(List<Integer> list, int len, int bgn, List<List<Integer>> rst, int n, int k){
    	if(len == k+1){
    		List<Integer> temp = new ArrayList<Integer>();
    		for(Iterator<Integer> iter = list.iterator() ; iter.hasNext(); ){
    			temp.add(iter.next());
    		}
    		rst.add(temp);
    		return;
    	}
    	list.add(len-1, 0);
    	for(int i = bgn; i <= n; i++){
    		list.set(len-1, i);
    		help(list, len+1, i+1, rst, n, k);
    	}
    	list.remove(len-1);
    }
    
    public static void main(String argv[]){
		
    	Combinations cb = new Combinations();
    	List<List<Integer>> rst = cb.combine(6, 5);
    	
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
