package backtrack;

public class FindPeakElement {
    // public int findPeakElement(int[] num) {
    //     if(num == null || num.length == 0){
    //         return 0;
    //     }
        
    //     int i = 0;
    //     while(true){
    //         if(i == num.length-1 || num[i] > num[i+1]){
    //             break;
    //         }
    //         i++;
    //     }
        
    //     return i;
    // }
    
    public int findPeakElement(int[] num) {
        if(num == null || num.length == 0){
            return 0;
        }
        
        return help(num, 0, num.length-1);
    }
    
    int help(int[] num, int left, int right){
        if(left == right)  return left;
        else if(left+1 == right){
            if(num[left] > num[right])  return left;
            else  return right;
        }
        int mid = (left + right)/2;
        if(num[mid] < num[mid-1])
            return help(num, left, mid-1);
        if(num[mid] < num[mid+1])
            return help(num, mid+1, right);
        return mid;
    }
}
