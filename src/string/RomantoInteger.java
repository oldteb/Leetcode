package string;

public class RomantoInteger {
    public int romanToInt(String s) {
        if(s == null){
            return 0;
        }
        return help(s);
    }
    
    int help(String s){
        if(s.length() == 0)
            return 0;
        int temp = convert(s.charAt(0));
        int rst = temp;
        int lc = 1;
        int i = 1;
        for(; i < s.length(); i++){
            if(getWeight(convert(s.charAt(i))) == getWeight(temp)){
                if(convert(s.charAt(i)) > temp){
                	rst = convert(s.charAt(i)) - rst;
                	i++;
                	break;
                }
                else{
                    rst += convert(s.charAt(i));
                    lc++;
                }
            }
            else if(getWeight(convert(s.charAt(i))) < getWeight(temp) && lc==1){
            	break;
            }
            else{
                if(lc == 1){
                    rst = convert(s.charAt(i)) - rst;
                    i++;
                }
                break;
            }
        }
        //System.out.println(rst);
        if(i == s.length())  return rst;
        s = s.substring(i);
        return rst + help(s);
    }
    
    int convert(char c){
        switch(c){
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
            default:
                return 0;
        }
    }
    
    int getWeight(int x){
        int w = 1;
        int l = 10;
        while(x/l != 0){
            l*=10;
            w++;
        }
        //System.out.println(x+"->"+w);
        return w;
    }
    
    public static void main(String[] argv){
    	RomantoInteger ri = new RomantoInteger();
    	System.out.println(ri.romanToInt("CCCXCVI"));
    }
}
