package string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
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
