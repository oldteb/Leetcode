package Array;

public class SearchinRotatedSortedArray2 {
	public boolean search(int[] A, int target) {
        if(A == null || A.length == 0){
        	return false;
        }
        int found = 0;
        int left = 0;
        int right = A.length-1;
        int mid = 0;
        while(left <= right){
        	mid = (left+right)/2;
        	if(A[mid] == target){
        		found = 1;
        		break;
        	}
        	if(mid == left){
        		if(A[right] == target)  return true;
        		break;
        	}
        	if(A[mid] == A[left]){
        		int i = mid+1;
        		while(i < A.length && A[i] == A[mid]){
        			i++;
        		}
        		if(i == A.length){
        			right = mid-1;
        		}
        		else{
        			left = i;
        		}
        		continue;
        	}
        	if(A[left] < A[mid]){
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
    	if(found == 0){
    		return false;
    	}
    	return true;
    }
}
