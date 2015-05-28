package string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> arrlist = new ArrayList<String>();
    	int ip_len = s.length();
    	int[] info = new int[4];
    	int temp_len = ip_len;
    	
    	if(ip_len > 12 || ip_len < 4){
    		return null;
    	}
    	
    	for(int i = 0; i < 4; i++){
    		int j = 1;
    		if( i == 3){
    			info[i] = temp_len;
    		}
        	while(temp_len - j < 3-i || temp_len - j > (3-i)*3){
        		j++;
        	}
        	info[i] = j;
        	temp_len = temp_len - j;
    	}
    	
    	arrlist.add((String)genString(info));
    	int bot = 3;
    	
    	while(bot != -1){
    		while(info[])
    		
    	}
    	
    	
    	
    	
    	
        
        return arrlist;
    }
    
    public String genString(int[] info){
    	
    	return new String("test");
    }
    
    public int[] genInfo(int[] info, int bot, int len){
    	for(int i = bot; i < 4; i++){
    		int j = 1;
    		if( i == 3){
    			info[i] = len;
    		}
        	while(len - j < 3-i || len - j > (3-i)*3){
        		j++;
        	}
        	info[i] = j;
        	len = len - j;
    	}
    	
		return info;
    }
}
