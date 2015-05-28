package Array;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int max = 0;
        if(height == null || height.length == 0){
        	return 0;
        }
        
        int lh = 0;
        int rh = height.length - 1;
        	
        while(lh < rh){
        	max = Math.max(max, Math.min(height[lh],height[rh]) * (rh - lh));
        	if(height[lh] < height[rh]){
        		lh++;
        	}
        	else{
        		rh--;
        	}
        }
        
        return max;
    }
    
}
