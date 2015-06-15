package Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0)  return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            if(map.get(nums[i]) == null)  map.put(nums[i],i);
            else{
                if(Math.abs(map.get(nums[i])-i) <= k)  return true;
                else  map.put(nums[i],i);
            }
        }
        return false;
    }
}
