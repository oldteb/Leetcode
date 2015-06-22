package Array;

/**
 * 
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 *
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * [show hint]
 *
 * Related problem: Reverse Words in a String II
 * 
 * 
 * 
 * @author yunhe
 *
 */
public class RotateArray {
	
	// naive way
     public void rotate1(int[] nums, int k) {
         k = k % nums.length;
         if( k <= 0 )  return;
         int[] buf = new int[k];
         for(int i = nums.length-k, j = 0; i < nums.length; i++, j++){
             buf[j] = nums[i];
         }
         for(int i = nums.length-k-1; i >= 0; i--){
             nums[i+k] = nums[i];
         }
         for(int i = 0; i < buf.length; i++){
             nums[i] = buf[i];
         }
     }
    
    //  double reverse
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        if( k <= 0 )  return;
        reverse(nums);
        int[] buf1 = new int[k];
        int[] buf2 = new int[nums.length - k];
        int i = 0;
        for(;i < k; i++)  buf1[i] = nums[i];
        for(;i < nums.length; i++)  buf2[i-k] = nums[i];
        reverse(buf1);
        reverse(buf2);
        i = 0;
        for(; i < k; i++)  nums[i] = buf1[i];
        for(; i < nums.length; i++)  nums[i] = buf2[i-k];
        
    }
    
    void reverse(int[] arr){
        for(int i = 0; i < arr.length/2; i++){
            int temp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = temp;
        }
    }
}
