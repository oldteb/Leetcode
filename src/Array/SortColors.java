package Array;

public class SortColors {
//    public void sortColors(int[] A) {
//        if(A == null || A.length == 0){
//            return;
//        }
//        int r = 0;
//        int w = 0;
//        int b = 0;
//        for(int i = 0; i < A.length; i++){
//            switch(A[i]){
//                case 0:
//                    r++;
//                    break;
//                case 1:
//                    w++;
//                    break;
//                case 2:
//                    b++;
//                    break;
//            }
//        }
//        for(int i = 0; i < A.length; i++){
//            if(r-- > 0)  A[i] = 0;
//            else if(w-- > 0)  A[i] = 1;
//            else if(b-- > 0)  A[i] = 2;
//        }
//        
//    }
	
    public void sortColors(int[] A) {
        if(A == null || A.length == 0){
            return;
        }  
        String.va
        int r = -1;
        int w = -1;
        int b = -1;
        for(int i = 0; i < A.length; i++){
            if(A[i] == 2){
                if(b == -1)  b = i;
            }
            else if(A[i] == 1){
                if(b != -1){
                    swap(A,b,i);
                    b++;
                    if(w == -1)  w = b-1;
                }
                else if(w == -1)  w = i;
            }
            else{
                int d = i;
                if(b != -1){
                    swap(A,b,i);
                    b++;
                    d = b-1;
                }
                if(w != -1){
                    swap(A,w,d);
                    w++;
                }
                if(r == -1)
                    r = 0;
            }
        }
    }
    
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
