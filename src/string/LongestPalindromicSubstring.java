package string;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
    	int top = -1;
    	int back = 1;
    	int max_len = 0;
    	int max_bgn = 0;
    	int lo_idx = 0;
    	int hi_idx = 0;
    	char cur;
    	
    	if(s.equals(null)){
    		return null;
    	}
    	else if(s.equals("")){
    		return "";
    	}
    	
    	StringBuilder sb = new StringBuilder(s);
    	char[] carray = new char[sb.length()];
    	
    	if(sb.length() == 1){
    		return s;
    	}
    	else if(sb.charAt(0) == sb.charAt(1)){
    		max_len = 2;
    		max_bgn = 0;
    	}
    	
    	
    	while(sb.length() != 0){
    		cur = sb.charAt(0);
    		if(top < 0){
    			carray[++top] = cur;
    			sb.deleteCharAt(0);
    			continue;
    		}
    		
    		back = 0;
    		if(top - 1 >= 0 && carray[top-1] == sb.charAt(0)){
        		while(top - back -1 >= 0 && back < sb.length() && carray[top - back - 1] == sb.charAt(back)){
        			back++;
        		}
        		
        		if(back != 0){
        			back = back * 2 + 1; 
                	if(back > max_len){
                		max_len = back;
                		max_bgn = top - (back-1)/2;
                	}
        		}
    		}
    		
    		
    		back = 0;
    		if(carray[top] == sb.charAt(0)){
        		while(top - back >= 0 && back < sb.length() && carray[top - back] == sb.charAt(back)){
        			back++;
        		}
        		
        		if(back != 0){
        			back = back * 2; 
                	if(back > max_len){
                		max_len = back;
                		max_bgn = top - back/2 +1;
                	}
        		}
    		}


			carray[++top] = cur;
			sb.deleteCharAt(0);
    		
    	}
    	
    	lo_idx = max_bgn;
    	hi_idx = max_bgn + max_len;
    	String result = s.substring(lo_idx, hi_idx);
    	
		return result;
        
    }
    
    void foo(int[] d){
    	d[0] = 10;
    }
    
    public static void main(String argv[]){
//    	String sstring = "gferaacdcaabd";
    	LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
//    	System.out.println(lps.longestPalindrome(sstring));
    	
    	int[] array = new int[5];
    	array[0] = 1;
    	lps.foo(array);
    	
    	System.out.println(array[0]);
    }
}

class testclass{
	public int a = 5;

}
