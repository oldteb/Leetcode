package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if(s == null){
        	return false;
        }
        else if(s.length() == 0){
        	return true;
        }
        Map<Character,Character> map = new HashMap<Character,Character>();
        map.put('(',')');
        map.put('[', ']');
        map.put('{', '}');
        StringBuffer sb = new StringBuffer(s);
        Stack<Character> stack = new Stack<Character>();
        
        while(sb.length() != 0){
        	Character c;
        	try{
        		c = map.get(stack.peek()); 	
        	}
        	catch(Exception e){
        		stack.push(sb.charAt(0));
        		sb.deleteCharAt(0);
        		continue;
        	}
        	if(c != null && c == sb.charAt(0)){
        		stack.pop();
        		sb.deleteCharAt(0);
        		continue;
        	}
        	else{
        		stack.push(sb.charAt(0));
        		sb.deleteCharAt(0);
        	}
        }
        if(stack.size() == 0) return true;
        return false;
    }
    
}
