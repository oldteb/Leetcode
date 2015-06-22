package string;

/**
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * 
 * 
 * @author yunhe
 *
 */
public class LengthofLastWord {
	// complicated code
    public int lengthOfLastWord1(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int last = 0;
        int temp = 0;
        
        for(int i = 0; i < s.length(); i++){
        	if(s.charAt(i) != ' ')  temp++;
        	else if(temp == 0)  continue;
        	else{
        		last = temp;
        		temp = 0;
        	}
        }
        if(temp != 0)  last = temp;
        return last;
    }
    
    //  simple code
    public int lengthOfLastWord2(String s) {
	    if(s == null || s.length() == 0)  return 0;
	    int count = 0;
	    int idx = s.length()-1;
	    while(idx >= 0 && s.charAt(idx) == ' ')  idx--;
	    if(idx < 0) return 0;
	    while(idx >= 0 && s.charAt(idx) != ' '){
	        count++;
	        idx--;
	    }
	    return count;
    }
    
    // RegEx solution
    public int lengthOfLastWord3(String s) {
         if(s == null || s.length() == 0)  return 0;
         String[] strs = s.split("\\s{1,}");
         return strs.length > 0 ? strs[strs.length-1].length() : 0;
    }
    
}
