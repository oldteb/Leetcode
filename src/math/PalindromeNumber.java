package math;
/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * 
 * @author yunhe
 *
 */
public class PalindromeNumber {
	//  simple code
    public boolean isPalindrome1(int x) {
        if(x < 0) return false;
        int baseL = 1;
        int baseR = 1;
        while(x/baseL != 0){
            if(Integer.MAX_VALUE/10 < baseL)  break; // Prevent overflow
            baseL *= 10;
        }
        if(Integer.MAX_VALUE/10 >= baseL) baseL /= 10;
        while(baseL > baseR){
            if((x/baseL)%10 != (x/baseR)%10) return false;
            baseL /= 10;
            baseR *= 10;
        }
        
        return true;
    }
    
    // complicated code
    public boolean isPalindrome2(int x) {
        if(x>=0 && x<10){
            return true;
        }
        else{
            if(x < 0){
                return false;
            }
            int w = getWeight(x);
            System.out.println(w);
            for(int l = w, r = 1; l > r;){
                if(getNum(x,l) != getNum(x,r)){
                    return false;
                }
                l = l/10;
                r = r*10;
            }
        }
        return true;
    }
    
    int getWeight(int x){
        int l = 10;
        while(x/l != 0){
            if(l==1000000000){
            	return l;
            }
            l *= 10;
        }
        return l/10;
    }
    
    int getNum(int x, int w){
        int temp = x/w;
        System.out.println(temp%10);
        return temp%10;
    }
    
    public static void main(String[] argv){
    	PalindromeNumber pn = new PalindromeNumber();
    	System.out.println(pn.isPalindrome2(2357532));
    	
    }
}
