package Array;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> rst = new ArrayList<Integer>();
    	rst.add(1);
    	if(rowIndex == 0){
    		return rst;
    	}
    	int temp = 1;
    	int tempsum;
    	for(int i = 1; i <= rowIndex; i++){
    		for(int j = 0; j < rst.size()-1; j++){
    			tempsum = temp + rst.get(j+1);
    			temp = rst.get(j+1);
    			rst.set(j+1, tempsum);
    		}
    		rst.add(temp);
    	}
    	
    	return rst;
    }
}
