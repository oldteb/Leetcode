package Array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0)  return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            int cap = Math.max(1,t);
            if(i-k-1 >= 0)  // delete old record from map
                map.remove(nums[i-k-1]/cap);
            for(int n = nums[i]/cap-1; n <= nums[i]/cap+1; n++)
                if(map.get(n) != null){
                    long arg1 = map.get(n);
                    long arg2 = nums[i];
                    if(Math.max(arg1,arg2) - Math.min(arg1,arg2) <= (long)t)  return true;
                }
            map.put(nums[i]/cap,nums[i]);
        }
        return false;
    }
}
