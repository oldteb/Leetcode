package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * Credits:
 * Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
 * 
 * 
 * @author yunhe
 *
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> rst = new ArrayList<String>();
        if(nums == null || nums.length == 0)  return rst;
        for(int i = 0; i < nums.length;){
            int base = i++;
            while(i < nums.length && nums[i]-nums[i-1] == 1)  i++;
            String temp;
            if(i-base == 1)  temp = Integer.toString(nums[base]);
            else temp = Integer.toString(nums[base]) + "->" + Integer.toString(nums[i-1]);
            rst.add(temp);
        }
        
        return rst;
        
    }
}
