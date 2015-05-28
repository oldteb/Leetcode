package string;

public class RomantoInteger2 {
	public int romanToInt(String s) {
		if(s == null){
			return 0;
		}
		int rst = 0;
		for(int i = 0; i < s.length(); i++){
			if(i == 0){
				rst += convert(s.charAt(0));
				continue;
			}
 			if(convert(s.charAt(i-1)) < convert(s.charAt(i))){
				rst = rst - 2*convert(s.charAt(i-1)) + convert(s.charAt(i));
			}
			else{
				rst += convert(s.charAt(i));
			}
		}
		return rst;
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
}
