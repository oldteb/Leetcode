package math;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
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
    	System.out.println(pn.isPalindrome(2357532));
    	
    }
}
