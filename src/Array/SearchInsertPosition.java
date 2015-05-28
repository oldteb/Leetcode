package Array;

public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0){
        	return 0;
        }
        int i = 0;
        
        for(i = 0; i < A.length; i++){
        	if(A[i] == target){
        		return i;
        	}
        	else if(A[i] < target){
        		continue;
        	}
        	else{
        		return i;
        	}
        }
        
        return i;
    }
}
