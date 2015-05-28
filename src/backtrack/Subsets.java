package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] S) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(S == null){
        	return null;
        }
        rst.add(new ArrayList<Integer>());
        if(S.length == 0){
        	return rst;
        }
        Arrays.sort(S);
        List<Integer> list = new ArrayList<Integer>();
        help(S, list, 1, 0, rst);

    	return rst;
    }
    
    void help(int[] S, List<Integer> list, int len, int bgn, List<List<Integer>> rst){
    	int i = 0;
    	if(bgn < S.length){
    		list.add(len-1,0);
    	}
    	for(i = bgn; i < S.length; i++){
    		list.set(len-1, S[i]);
    		List<Integer> temp = new ArrayList<Integer>();
    		for(Iterator iter = list.iterator(); iter.hasNext();){
    			temp.add((Integer)iter.next());
    		}
    		rst.add(temp);
    		help(S, list, len+1, i+1, rst);
    	}
    	if(i != bgn)
    		list.remove(len-1);
    }
    
    public static void main(String argv[]){
    	
    	Subsets ss = new Subsets();
    	int[] S = {0};
    	List<List<Integer>> rst = ss.subsets(S);
    	
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
