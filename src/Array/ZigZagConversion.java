package Array;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if(s == null || s.length() == 0 || nRows == 0){
        	return "";
        }
        if(nRows == 1){
        	return s;
        }
        
        List<String> rst = new ArrayList<String>();
        for(int i = 0; i < nRows; i++){
        	rst.add(new String());
        }
        int i = 0, mark = 0, lvl = 0;
        while( i < s.length()){
        	String temp = rst.get(lvl);
        	temp += s.charAt(i++);
        	rst.set(lvl, temp);
        	if(mark == 0 ){
        		lvl++;
        	}
        	else{
        		lvl--;
        	}
        	if(lvl >= nRows){
        		mark = 1;  lvl -= 2;
        	}
        	else if(lvl == -1){
        		mark = 0;  lvl += 2;
        	}
        }
        String ss = "";
        for(int k = 0; k < nRows; k++){
        	ss += rst.get(k);
        }
        
        return ss;
    }
}
