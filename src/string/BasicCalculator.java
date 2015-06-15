package string;

import java.util.Stack;

public class BasicCalculator {
	
    public int calculate(String s) {
        if(s == null)  return -1;
        String s1 = s.replaceAll("\\s++","");
        if(s1.length() <= 0)  return -1;
        Stack<Integer> stack = new Stack<Integer>();
        Stack<String> opt = new Stack<String>();
        IdxRec idx = new IdxRec(0);
        Object token = nextToken(s1,idx);
        while(token != null){
        	if(token instanceof Integer){
        		if(opt.size() == 0 || opt.peek().equalsIgnoreCase("("))
        			stack.push((Integer)token);
        		else{
        			if(opt.peek().equalsIgnoreCase("+"))
        				stack.set(stack.size()-1, stack.peek()+(Integer)token);
        			else
        				stack.set(stack.size()-1, stack.peek()-(Integer)token);	
        			opt.pop();
        		}
        	}
        	else{
        		if(token.toString().equalsIgnoreCase(")")){
        			opt.pop();
        			if(opt.size() != 0 && !opt.peek().equalsIgnoreCase("(")){
        				int temp = stack.pop();
            			if(opt.peek().equalsIgnoreCase("+"))
            				stack.set(stack.size()-1, stack.peek()+temp);
            			else
            				stack.set(stack.size()-1, stack.peek()-temp);	
            			opt.pop();
        			}
        		}
        		else  opt.push(token.toString());
        	}
        	token = nextToken(s1,idx);
        }
        return stack.pop();
        
    }
    
    Object nextToken(String s, IdxRec idx){
    	if(idx.val >= s.length())  return null;
    	if(s.charAt(idx.val) == '('
    		|| s.charAt(idx.val) == ')'
    		|| s.charAt(idx.val) == '+'
    		|| s.charAt(idx.val) == '-'){
    		return Character.toString(s.charAt(idx.val++));
    	}
    	else{
    		return getVal(s, idx);
    	}
    }
    
    int getVal(String s, IdxRec idx){
        int rst = 0;
        int sign = 1;
        if(s.charAt(idx.val)=='-'){
            sign = -1;
            idx.val++;
        }  
        do{
            rst *= 10;
            rst += s.charAt(idx.val++)-'0';
        }
        while(idx.val < s.length() && (s.charAt(idx.val) >= '0' && s.charAt(idx.val) <= '9'));
        return rst*sign;
    }
    
    class IdxRec{
        public int val = 0;
        IdxRec(int idx){
            this.val = idx;
        }

    }
    
    public static void main(String[] args) {
    	BasicCalculator bc = new BasicCalculator();
    	bc.calculate(" 30");
	}

}
