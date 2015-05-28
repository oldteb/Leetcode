package Array;

import java.util.Arrays;

public class ThreeSumClosest2 {
	public int threeSumClosest(int[] num, int target) {
		int closet_sum = 0;
		int dis = Integer.MAX_VALUE;
		
		if(num == null || num.length < 3){
			return 0;
		}
		Arrays.sort(num);
		//System.out.println("haha");
		for(int i = 0; i < num.length-1; i++){
			int j = i+1;
			int k = num.length - 1;
			
			while(j < k){
				int temp = num[i] + num[j] + num[k];
				if(temp == target){
					return temp;
				}
				else if(temp < target){
					if(target - temp < dis){
						closet_sum = temp;
						dis = target - temp;
					}
					j++;
				}
				else{
					if(temp - target < dis){
						closet_sum = temp;
						dis = temp - target;
					}
					k--;
				}
			}
			
			while(i+1 < num.length && num[i] == num[i+1])
				i++;

		}
		
		return closet_sum;
	}
	
    public static void main(String argv[]){
    	int[] num = {6,-34,70,-43,1,-74,56,-18,-47,44,43,-96,-81,-65,68,60,-9,59,-52,32,61,41,31,56,94,-53,-94,-35,38,55,20,-12,40,-41,-38,-10,10,16,-42,85,-38,4,-18,72,-39,95,-73,-55,-43,-70,0,46,97,-84,-67,-5,-37,68,15,-78,31,-80,-44,-48,-28,-100,-97,-4,6,-29,-21,-76,10,46,-49,80,27,-16,92,-90,-82,-13,-67,70,37,79,34,-48,-65,70,-15,60,6,45,41,16,56,67,-79,28,2,39,28,-80,-13,-72,-97,-37,-8,-100,-83,-37,-77,26,74,-36,-28,-78,-95,-81,39,-1,-50,4,87,-39,-52,6,-13,-16,-53,-95,94,2,-61,61,-1,-68,-33,-76,-41,54,57,-54,-24,-55,88,-58,53,0,76,-46,56,-95,17,-74,50,84,-19,-9,39,20,46,40,38,-46,-68,57,38,-44,-53,80};
    	int[] num1 = {-1,2,1,-4};
    	ThreeSumClosest2 tsc = new ThreeSumClosest2();
    	int rst = tsc.threeSumClosest(num,0);
    	
    	System.out.println(rst);
    }
	
}
