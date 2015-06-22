package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * 
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * 
 * @author yunhe
 *
 */
public class ValidParentheses {
	
	//  simple code
    public boolean isValid1(String s) {
        if(s == null || s.length() == 0)  return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{') stack.push(c);
            else if(stack.size() != 0){
                String temp = ((new StringBuilder()).append(stack.peek()).append(c)).toString();
                if(temp.equalsIgnoreCase("()") || temp.equalsIgnoreCase("[]") || temp.equalsIgnoreCase("{}"))
                    stack.pop();
                else return false;
            }
            else  return false;
        }
        if(stack.size() == 0)  return true;
        else return false;
    }
	
	//  complicated code
    public boolean isValid2(String s) {
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
