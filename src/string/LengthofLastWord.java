package string;

public class LengthofLastWord {
    public int lengthOfLastWord(String s) {
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
}
