package math;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
    public boolean isHappy(int n) {
        if(n <= 0)  return false;
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        while(map.get(new Integer(n)) == null){
            map.put(new Integer(n), 1);
            int temp = n;
            n = 0;
            while(temp != 0){
                n += Math.pow(temp%10,2);
                temp /= 10;
            }
            if(n == 1)  return true;
        }
        
        return false;
    }
}
