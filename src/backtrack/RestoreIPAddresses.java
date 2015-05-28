package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        if(s == null){
        	return  null;
        }
        else if(s.length() == 0){
        	return new ArrayList<String>();
        }
        
        List<String> rst = new ArrayList<String>();
        int[] idx = {0,0,0,0};
        help(s,idx,1,rst);
        
        return rst;
    }
    
    void help(String s, int[] idx, int lvl, List<String> rst){
    	if(lvl == 4){
    		if(isValid(s.substring(idx[3]))){
    			//System.out.println("->" + s.substring(idx[lvl-2]));
    			rst.add(genOne(s, idx));
    		}
    		return;
    	}
    	for(idx[lvl] = idx[lvl-1]+1; idx[lvl] < s.length(); idx[lvl]++){
        	if(isValid(s.substring(idx[lvl-1],idx[lvl]))){
        		help(s,idx,lvl+1,rst);
        	}
        	else{
        		return;
        	}
    	}
    }
    
    boolean isValid(String s){
		try{
			if(Integer.parseInt(s) >= 0 && Integer.parseInt(s) < 256){
				//System.out.println("->" + s);
				Integer i = Integer.parseInt(s);
				i.toString();
				if(s.length() == i.toString().length()){
					return true;
				}
				else
					return false;
			}
		}catch(NumberFormatException nfe){
			return false;
		}
		return false;
    }
    
    String genOne(String s, int[] idx){
    	String newone = new String(s);
    	StringBuffer sb = new StringBuffer(newone);
    	sb.insert(idx[1], '.');
    	sb.insert(idx[2]+1, '.');
    	sb.insert(idx[3]+2, '.');
    	return sb.toString();
    }
    
    public static void main(String[] argv){
    	RestoreIPAddresses pipa = new RestoreIPAddresses();
    	List<String> rst = pipa.restoreIpAddresses("10110101");
    	for(String s : rst){
    		System.out.println(s);
    	}
    }
}
