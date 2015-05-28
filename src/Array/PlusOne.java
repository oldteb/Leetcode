package Array;


public class PlusOne {
    public int[] plusOne(int[] digits) {
    	int up = 0;
    	int i;
    	int len = digits.length;
		if(digits[len-1] == 9){
			digits[len-1] = 0;
			up = 1;
		}
		else{
			digits[len-1] = digits[len-1]+1;
			up = 0;
		}
    	for(i = len-2; i >= 0; i--){
    		if(up == 0)
    			break;
    		if(digits[i] == 9){
    			digits[i] = 0;
    			up = 1;
    		}
    		else{
    			digits[i] = digits[i]+1;
    			up = 0;
    			break;
    		}
    		
    	}
    	
    	if(up == 0)
    		return digits;

    	int[] newdigits = new int[len+1];
    	newdigits[0] = 1;
    	for(int j = 0; j<len; j++){
    		newdigits[j+1] = digits[j];
    	}
    	
    	return newdigits;
    }
    
    
    public static void main(String argv[]){
    	int[] a = {9,9,9,9,8};
    	PlusOne po = new PlusOne();
    	int[] b = po.plusOne(a);
    	for(int i = 0; i<b.length; i++){
    		System.out.print(b[i]);
    	}
    }
}