package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
    	if(digits == null){
    		return null;
    	}
    	StringBuilder sb = new StringBuilder(digits);
    	List<String> digitString = Arrays.asList("","","abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz");
    	ArrayList<String> arrlist = new ArrayList<String>();
    	
    	if(sb.length() == 0){
    		arrlist.add("");
    		return arrlist;
    	}
    	
    	while(sb.length() != 0){
    		if(sb.charAt(0) == '0' || sb.charAt(0) == '1'){
    			sb.deleteCharAt(0);
    			continue;
    		}
    		//StringBuilder tempsb = new StringBuilder(digitString.get(sb.charAt(0)-'0'));
    		String temp = digitString.get(sb.charAt(0)-'0');
    		int count = temp.length();
    		int curr_len = arrlist.size();
			sb.deleteCharAt(0);
			//temp = (new StringBuilder(temp)).reverse().toString();
			sb.insert(0, temp);
			
			if(curr_len == 0){
				for(int i = 0; i < count; i++){
					arrlist.add(0, String.valueOf(sb.charAt(count -i - 1)));
					sb.deleteCharAt(count -i - 1);
				}
				continue;
			}
			
			// copy
			for(int j = 0; j < count-1; j++){
				for(int k = 0; k < curr_len; k++){
					arrlist.add(arrlist.get(k));
				}
			}
			
			for(int j = 0; j < count; j++){
				for(int k = 0; k < curr_len; k++){
					String temps = arrlist.get((j*curr_len)+k);
					String chgs = new String(temps + String.valueOf(sb.charAt(j)));
					arrlist.set((j*curr_len)+k, chgs);
				}
			}
			
			for(int i = 0; i < count; i ++){
				sb.deleteCharAt(0);
			}
    	}
    	
		return arrlist;
    }
    
    
    public static void main(String argv[]){
    	LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
    	List<String> list = lcpn.letterCombinations("2");
    	
    	for(int i = 0; i < list.size(); i++){
    		System.out.print(list.get(i) + ",");
    	}
    	
    }
}
