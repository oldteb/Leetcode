package math;


/**
 * Given an integer, write a function to determine if it is a power of two.
 *  
 * @author yunhe
 *
 */
public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)  return false;
        int count = 0;
        for(int i = 0; i < 31; i++){
            count += (n>>i) & 1;
        }
        if(count == 1) return true;
        else return false;
    }
}
