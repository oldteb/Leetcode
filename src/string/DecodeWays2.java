package string;

public class DecodeWays2 {
    public int numDecodings(String s) {
    	if(s == null || s.length() == 0 || s.charAt(0) == '0'){
    		return 0;
    	}
        int[] info = new int[100];
        for(int i = 1; i < 27; i++){
        	info[i] = 1;
        }
    	int[][] buf = new int[2][s.length()];
    	buf[0][0] = 1;
    	
    	for(int i = 1; i < s.length(); i++){
    		String sub;
    		if(i == s.length()-1){
    			sub = s.substring(i-1);
    		}
    		else{
    			sub = s.substring(i-1, i+1);
    		}
    		if(info[new Integer(sub)] == 1 && s.charAt(i-1) != '0'){
        			buf[1][i] = buf[0][i-1];
    		}
    		if(s.charAt(i) != '0'){
    			buf[0][i] = buf[0][i-1] + buf[1][i-1];
    		}
    	}
    	
    	return buf[0][s.length()-1] + buf[1][s.length()-1];
    }
    
	public static void main(String argv[]){
		DecodeWays2 dw = new DecodeWays2();
		System.out.println(dw.numDecodings("10121"));
	}
}
