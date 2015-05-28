package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> rst = new ArrayList<List<Integer>>();
    	if(numRows == 0){
    		return rst;
    	}
    	
    	for(int i = 1; i <= numRows; i++){
    		List<Integer> temp = new ArrayList<Integer>();
    		temp.add(1);
    		if(i == 1){
    			rst.add(temp);
    			continue;
    		}
    		for(int j = 0; j < rst.get(rst.size()-1).size()-1; j++){
    			temp.add(rst.get(rst.size()-1).get(j)+rst.get(rst.size()-1).get(j+1));
    		}
    		temp.add(1);
    		rst.add(temp);
    	}
    	
    	return rst;
    }
}
