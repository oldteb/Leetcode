package Array;

/**
 * 
 * <p>Given an array of n integers where n > 1, nums, return an array
 * output such that output[i] is equal to the product of all the 
 * elements of nums except nums[i].
 *
 * <p>Solve it without division and in O(n).
 * 
 * <p>For example, given [1,2,3,4], return [24,12,8,6].
 * 
 * <p><strong>Follow up:</strong>
 * Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 * 
 * @author yunhe
 *
 */
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)  return null;
        int[] rst = new int[nums.length];
        int temp = 1;
        int zeroIdx = -1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(zeroIdx != -1)  return rst;
                zeroIdx = i;
                continue;
            }
            temp *= nums[i];
        }
        if(zeroIdx != -1){
            rst[zeroIdx] = temp;
            return rst;
        }
        for(int i = 0; i < nums.length; i++){
            rst[i] = temp/nums[i];
            
        }
        
        return rst;
            
    }
}
