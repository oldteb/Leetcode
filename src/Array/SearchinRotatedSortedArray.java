package Array;

public class SearchinRotatedSortedArray {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0){
        	return 0;
        }
        int left = 0;
        int right = A.length-1;
        int mid = 0;
        while(left <= right){
        	mid = (left+right)/2;
        	if(A[mid] == target){
        		return mid;
        	}
        	if(A[left] <= A[mid]){
        		if(target >= A[left] && target < A[mid]){
        			right = mid-1;
        			continue;
        		}
        		else{
        			left = mid+1;
        			continue;
        		}
        	}
        	else{
        		if(target > A[mid] && target <= A[right]){
        			left = mid+1;
        			continue;
        		}
        		else{
        			right = mid-1;
        			continue;
        		}
        	}
        }
        
    	return -1;
    }
}
