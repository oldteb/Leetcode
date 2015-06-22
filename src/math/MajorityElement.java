package math;

import java.util.Arrays;

/**
 * 
 * Given an array of size n, find the majority element. The majority element is the element that appears more than  n/2  times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * 
 * 
 * @author yunhe
 *
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0)  return -1;
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
