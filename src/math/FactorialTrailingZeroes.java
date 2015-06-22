package math;

/**
 * 
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 * 
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 * 
 * 
 * @author yunhe
 *
 */

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if(n <= 0)  return 0;  // Leetcode test case is wrong because 0 factorial is 1
        
        // count the number of times 5,25,125... appears in 1~n
        int count = 0;
        int base = 5;
        
        while(base <= n){
            count += n/base;
            if(Integer.MAX_VALUE/5 < base)  break;  // prevent overflow...
            base *= 5;
        }
        
        return count;
        
    }
}
