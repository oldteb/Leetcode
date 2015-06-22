package dynamicProgramming;

public class HouseRobber {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)  return 0;
        int a = nums[0];
        int b = 0;
        for(int i = 1; i < nums.length; i++){
            int temp = b;
            b = Math.max(a,b);
            a = temp + nums[i];
        }
        return Math.max(a,b);
    }
}
