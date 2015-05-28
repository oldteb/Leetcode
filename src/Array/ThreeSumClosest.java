package Array;

import java.util.Arrays;

public class ThreeSumClosest {
	int stat = 0;
	int closet_sum = 0;;
	int target;
	
    public int threeSumClosest(int[] num, int target) {
    	this.target = target;
    	int[] idx = new int[3];
    	idx[0] = idx[1] = idx[2] = -1;
    	if(num == null || num.length < 3){
    		return 0;
    	}
    	else if(num.length == 3){
    		return num[0]+num[1]+num[2];
    	}    	
    	help(num,idx,0);

		return closet_sum;
		
    }
    
    public void help(int[] num, int[] idx, int level){
    	if(level == 0){
    		for(int i = 0; i < num.length; i++){
    			idx[level] = i;
    			help(num,idx,level+1);
    		}
    	}
    	else if(level == 3){
    		if(stat == 0){
    			closet_sum = num[idx[0]] + num[idx[1]] + num[idx[2]];
    			stat = 1;
    		}
    		else{
    			int temp = num[idx[0]] + num[idx[1]] + num[idx[2]];
    			if(Math.abs(target - temp) < Math.abs(target - closet_sum)){
    				closet_sum = temp;
    			}
    		}
    		return;
    	}
    	else{
        	for(int i = 0; i < num.length; i++){
        		if(i == idx[0] || i == idx[1]){
        			continue;
        		}
        		idx[level] = i;
        		help(num,idx,level+1);
        	}
    	}
    }
    
//    public static void main(String argv[]){
//    	int[] num = {6,-34,70,-43,1,-74,56,-18,-47,44,43,-96,-81,-65,68,60,-9,59,-52,32,61,41,31,56,94,-53,-94,-35,38,55,20,-12,40,-41,-38,-10,10,16,-42,85,-38,4,-18,72,-39,95,-73,-55,-43,-70,0,46,97,-84,-67,-5,-37,68,15,-78,31,-80,-44,-48,-28,-100,-97,-4,6,-29,-21,-76,10,46,-49,80,27,-16,92,-90,-82,-13,-67,70,37,79,34,-48,-65,70,-15,60,6,45,41,16,56,67,-79,28,2,39,28,-80,-13,-72,-97,-37,-8,-100,-83,-37,-77,26,74,-36,-28,-78,-95,-81,39,-1,-50,4,87,-39,-52,6,-13,-16,-53,-95,94,2,-61,61,-1,-68,-33,-76,-41,54,57,-54,-24,-55,88,-58,53,0,76,-46,56,-95,17,-74,50,84,-19,-9,39,20,46,40,38,-46,-68,57,38,-44,-53,80};
//    	ThreeSumClosest tsc = new ThreeSumClosest();
//    	int rst = tsc.threeSumClosest(num,0);
//    	
//    	System.out.println(rst);
//    }
}
