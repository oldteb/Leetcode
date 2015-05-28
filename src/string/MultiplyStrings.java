package string;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {
    	
    	String str1 = new StringBuilder(num1).reverse().toString();
    	String str2 = new StringBuilder(num2).reverse().toString();
    	
    	if(str1 == null || str2 == null){
    		return null;
    	}
    	else if(str1.equals("0") || str2.equals("0")){
    		return "0";
    	}
    	
    	
    	int[] result = new int[str1.length() + str2.length()];
    	for(int i = 0; i<str1.length(); i++){
    		for(int j = 0; j<str2.length(); j++){
    			result[i+j] += (str1.charAt(i) - '0') * (str2.charAt(j) - '0');
    		}
    	}
    	int digit = 0;
    	int carry = 0;
    	int temp;
    	
    	StringBuilder sb = new StringBuilder();
    	
    	for(int i = 0;i<str1.length() + str2.length();i++){
    		digit = (result[i] + carry)%10;
    		carry = (result[i] + carry)/10;
    		sb.insert(0, digit);
    	}
    	
    	while(sb.charAt(0) == '0'){
    		sb.deleteCharAt(0);
    	}
    	
    	return sb.toString();
        
    }
    
    
    public static void main(String argv[]){
    	String s1 = "0";
    	String s2 = "0";
    	MultiplyStrings ms = new MultiplyStrings();
    	System.out.println(ms.multiply(s1,s2));
    }
}
