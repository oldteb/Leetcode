package string;

/**
 * 
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 *
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 *
 * For the purpose of this problem, we define empty string as valid palindrome.
 * 
 * 
 * @author yunhe
 *
 */


public class ValidPalindrome {
	
	// simple version
    public boolean isPalindrome1(String s) {
        if(s == null || s.length() == 0)  return true;
        String lows = s.toLowerCase();
        int first = 0;
        int last = lows.length()-1;
        while(first < last){
            if(!valid(lows.charAt(first))){
                first++;  continue;
            }
            if(!valid(lows.charAt(last))){
                last--;  continue;
            }
            if(lows.charAt(first) == lows.charAt(last)){
                first++;   last--;   continue;
            }
            else  return false;
        }
        
        return true;
    }
    
    boolean valid(char c){
        if(c < 48 || c > 57 && c < 97 || c > 122)  return false;
        else return true;
    }
    
    // complicated version
    public boolean isPalindrome2(String s) {
        if(s.length() == 0){
            return true;
        }
        int left = 0;
        int right = s.length()-1;
        String str = s.toLowerCase();
        
        while(left < right){
            while(str.charAt(left) < 48 || (str.charAt(left) > 57 && str.charAt(left) < 97) || str.charAt(left) > 122){
                left++;
                if(left == right){
                    return true;
                }
            }
            while(str.charAt(right) < 48 || (str.charAt(right) > 57 && str.charAt(right) < 97) || str.charAt(right) > 122){
                right--;
                if(left == right){
                    return true;
                }
            }
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] argv){
    	ValidPalindrome vp = new ValidPalindrome();
    	System.out.println(vp.isPalindrome("a.bc343c,ba"));
    }
}
