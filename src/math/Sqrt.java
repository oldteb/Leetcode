package math;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 * 
 * @author yunhe
 * 
 */

public class Sqrt {
    public int mySqrt(int x) {
        if(x < 0)  return -1;
        int root = 0;
        int num = 0;
        while(num < x){
            if(Integer.MAX_VALUE - num < (2*root+1)){  // overflow
                return root;
            }
            num += 2*root+1;
            root++;
        }
        if(num == x)  return root;
        else return root-1;
    }
}
