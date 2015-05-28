package string;

import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
    	StringBuilder sb = new StringBuilder(path);
    	if(path == null){
    		return null;
    	}
    	else if(path.equals("")){
    		return null;
    	}
    	Stack<String> stack = new Stack<String>();
    	
    	while(sb.length() != 0 && sb.charAt(0) != '/'){
    		sb.deleteCharAt(0);
    	}
    	if(sb.length() == 0){
    		return null;
    	}
    	else{
    		sb.deleteCharAt(0);
    	}
    	
    	while(sb.length() != 0){
    		int i = 0;
    		for(;i < sb.length(); i++){
    			if( sb.charAt(i) == '/'){
    				break;
    			}
    		}
    		String temp;
    		if(i == 0){
    			sb.deleteCharAt(0);
    			continue;
    		}
    		else if(i == sb.length()){
    			temp = sb.substring(0);
    		}
    		else{
    			temp = sb.substring(0, i);
    		}
    		
    		while(i-1 > -1){
    			sb.deleteCharAt(i-1);
    			i--;
    		}
    		if(temp.equals(".")){
    			continue;
    		}
    		else if(temp.equals("..")){
    			if(stack.size() == 0){
    				continue;
    			}
    			stack.pop();
    		}
    		else{
    			stack.push(temp);
    		}
    	}
    	
    	while(stack.size() != 0){
    		sb.insert(0, stack.pop());
    		sb.insert(0, "/");
    	}
    	
    	if(sb.length() == 0){
    		return "/";
    	}
    	else{
    		return sb.toString();
    	} 
    }
    
    public static void main(String argv[]){
    	SimplifyPath sp = new SimplifyPath();
    	System.out.println(sp.simplifyPath("/../../abc/ds/gdfgvfd/../../.."));
    }
    
    
	
	
	
	
}
