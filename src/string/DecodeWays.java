package string;

public class DecodeWays {
    public int numDecodings(String s) {
        if(s == null || s.length() == 0){
        	return 0;
        }
        int[] info = new int[100];
        for(int i = 1; i < 27; i++){
        	info[i] = 1;
        }
        
        return help(s,0,info);
    }

	int help(String s, int i, int[] info) {
		int count = 0;
		if(i == s.length() - 1){
			return 1;
		}
		count += help(s, i+1, info);
		
		if(i == s.length() - 2){
			int d = new Integer(s.substring(i));
			if(info[d] == 1){
				return ++count;
			}
			else
				return count;
		}
		
		count += help(s, i+2, info);

		return count;
	}
	
    public int numDecodings3(String s) {
        if(s == null || s.length() == 0)  return 0;
        int sgl = 1;
        int dbl = 0;
        int idx = 0;
        if(s.charAt(0) == '0')  return 0;
        for(int i = idx+1; i < s.length(); i++){
            int num = Integer.parseInt(s.substring(i-1,i+1));
            int temp = sgl;
            if(num >= 10 && num < 27){
                sgl = s.charAt(i) == '0' ? 0 : sgl + dbl;
                dbl = temp;
            }
            else if(s.charAt(i) == '0')  return 0;
            else{
                sgl = sgl + dbl;
                dbl = 0;
            }
        }
        return sgl + dbl;
    }
	
	public static void main(String argv[]){
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings3("10"));
	}
}
