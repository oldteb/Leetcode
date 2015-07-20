package math;
/**
 * <p>Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * 
 * <p>For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * @author yunhe
 *
 */
public class NumberofDigitOne {
    public int countDigitOne(int n) {
        int rst = 0;
        int lvl = 10;
        
        while(true){
            int base = n/lvl;
            rst += base * (lvl/10);
            if(n%lvl - lvl/10 >= 0)  rst += Math.min(n%lvl - lvl/10 + 1, lvl/10);
            if(Integer.MAX_VALUE/10 < lvl && n/lvl != 0){  // prevent integer overflow
                rst += Math.min(n - lvl + 1, lvl);
                break;
            }
            if(base == 0) break;
            else lvl *= 10;
        }
        
        return rst;
    }
}
