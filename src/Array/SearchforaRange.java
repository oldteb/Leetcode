package Array;

public class SearchforaRange {
    public int[] searchRange(int[] A, int target) {
        if(A == null || A.length == 0){
        	return new int[2];
        }
        int[] rst = new int[2];
        rst[0] = -1;
        rst[1] = -1;
        int left = 0;
        int right = A.length-1;
    	while(left <= right){
    		int mid = (left+right)/2;
    		if(A[mid] == target){
    			rst[0] = mid-1;
    			rst[1] = mid+1;
    			while(rst[0] >= 0 && A[rst[0]] == target){
    				rst[0]--;
    			}
    			if(rst[0] < 0)   
    				rst[0] = 0;
    			else
    				rst[0]++;
    			
    			while(rst[1] < A.length && A[rst[1]] == target){
    				rst[1]++;
    			}
    			if(rst[1] == A.length)   
    				rst[1] = A.length-1;
    			else
    				rst[1]--;
    			break;
    		}
    		if(target < A[mid]){
    			right = mid-1;
    		}
    		else{
    			left = mid+1;
    		}
    	}

        return rst;
    }
}
