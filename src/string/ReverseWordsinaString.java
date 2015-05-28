package string;

import java.util.ArrayList;

public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if(s == null){
        	return null;
        }
        else if(s.equals("")){
        	return "";
        }
        ArrayList<String> arrlist = new ArrayList<String>();
        
    	
        for(int i = 0; i < s.length();i++){
        	if(s.charAt(i) == ' '){
        		continue;
        	}
        	
        	int j = i+1;
        	while(j < s.length() && s.charAt(j) != ' ')
        		j++;
        	
        	String temp = s.substring(i,j);
        	arrlist.add(0, temp);
        	i = j;
        }
        
        String result = new String();
        if(arrlist.size() == 0){
        	return "";
        }
        while(arrlist.size() > 1){
        	result = result + arrlist.get(0) + " ";
        	arrlist.remove(0);
        }
        result = result + arrlist.get(0);
    	
    	return result;
    }
    
    
    public static void main(String argv[]){
    	ReverseWordsinaString rws = new ReverseWordsinaString();
    	System.out.println(rws.reverseWords("a c  "));
    	
    }
}
