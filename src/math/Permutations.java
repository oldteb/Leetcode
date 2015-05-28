package math;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
        if(num == null){
        	return null;
        }
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(num.length == 0){
        	return rst;
        }
        
        for(int i = 0; i < num.length; i++){
        	if(i == 0){
            	List<Integer> temp = new ArrayList<Integer>();
            	temp.add(num[i]);
            	rst.add(temp);
            	continue;
        	}
        	rst = help(rst, num[i]);
        }
        
        return rst;
    }
    
    List<List<Integer>> help(List<List<Integer>> rst, int number){
    	List<List<Integer>> rst2 = new ArrayList<List<Integer>>();
    	for(int i = 0; i < rst.size(); i++){
    		for(int j = 0; j < rst.get(i).size()+1; j++){
    			List<Integer> temp = new ArrayList<Integer>();
    			mycopy( rst.get(i), temp);
    			temp.add(j, number);
    			rst2.add(temp);
    		}
    	}
    	return rst2;
    }
    
    void mycopy(List<Integer> src, List<Integer> dest){
    	for(Integer i : src){
    		dest.add(i);
    	}
    }
    
    
    public static void main(String[] argv){
    	Permutations p = new Permutations();
    	int[] num = {};
    	p.permute(num);
    }
}
