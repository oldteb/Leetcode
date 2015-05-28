package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
    	ArrayList<String> result = new ArrayList<String>();
    	if(n == 0){
    		return result;
    	}
    	char[] buf = new char[n*2];
    	
    	buf[0] = '(';
    	help(n,1,0,buf,result);
    	
		return result;	
    }
    
    void help(int n, int num_lp, int num_rp, char[] buf, ArrayList<String> result){
    	if(num_lp > n || num_rp > n)
    		return;
    	if(num_lp == n){
    		for(int i = 0; num_lp+num_rp+i < 2*n; i++){
    			buf[num_lp+num_rp+i] = ')';
    		}
    		result.add(String.valueOf(buf));
    		return;
    	}
    	if(num_lp < num_rp){
    		return;
    	}
    	
    	buf[num_lp+num_rp] = '(';
    	help(n,num_lp+1,num_rp,buf,result);
    	buf[num_lp+num_rp] = ')';
    	help(n,num_lp,num_rp+1,buf,result);
    }
    
    
    public static void main(String argv[]){
    	GenerateParentheses gp = new GenerateParentheses();
    	ArrayList<String> result = (ArrayList)gp.generateParenthesis(4);
    	for(String s: result){
    		System.out.println(s);
    	}
    	
    }
}
