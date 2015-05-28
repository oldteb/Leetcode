package Array;

public class Searcha2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0){
        	return false;
        }
    	int left = 0;
    	int right = matrix.length -1;
    	int mid = 0;
    	int row = 0;
    	
    	while(left < right){
    		mid = (left+right)/2;
    		if(matrix[mid][0] == target){
    			return true;
    		}
    		else{
    			if(target < matrix[mid][0]){
    				right = mid-1;
    			}
    			else{
    				left = mid+1;
    			}
    		}
    	}
    	if(target < matrix[left][0]){
    		left--;
    	}
    	for(row = left, left = 0, right = matrix[0].length-1; row >= 0 && left <= right; ){
    		mid = (left+right)/2;
    		if(matrix[row][mid] == target){
    			return true;
    		}
    		else{
    			if(target < matrix[row][mid]){
    				right = mid - 1;
    			}
    			else{
    				left = mid + 1;
    			}
    		}
    	}
  
        return false;
    }
}
