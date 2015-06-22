package Array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * 
 * @author yunhe
 *
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0)  return 0;
        int len = nums.length;
        int idx = 0;
        while(idx < len){
            if(nums[idx] == val){
                int temp = nums[idx];
                nums[idx] = nums[len-1];
                nums[len-1] = temp;
                len--;  
            }
            else{
                idx++;
            }
        }
        return len;
    }
}
