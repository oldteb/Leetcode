package string;

/**
 * 
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * 
 * @author yunhe
 *
 */
public class AddBinary {
	
	// simple solution
    public String addBinary1(String a, String b) {
        if(a == null || b == null)  return "";
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for(;i >= 0 || j >= 0; i--, j--){
            int m = ( i>=0 ? a.charAt(i)-48 : 0);
            int n = ( j>=0 ? b.charAt(j)-48 : 0);
            sb.append((char)((m+n+carry)%2 + 48));
            carry = (m+n+carry)/2;
        }
        if(carry == 1)
            sb.append('1');
        return sb.reverse().toString();
    }
    
    
    // complicated solution
    public String addBinary2(String a, String b) {
        if(a == null || a.length() == 0)  return b;
        else if(b == null || b.length() == 0)  return a;
        int i = 0;
        int c = 0;
        int r = 0;
        StringBuffer sba = new StringBuffer(a);
        StringBuffer sbb = new StringBuffer(b);
        StringBuffer rst = new StringBuffer();
        sba.reverse();
        sbb.reverse();
        while(i < Math.max(a.length(),b.length())){
            int t1 = 0, t2 = 0;
            if(i < a.length())  t1 = sba.charAt(i)-48;
            if(i < b.length())  t2 = sbb.charAt(i)-48;
            int s = t1 + t2 + c;
            r = s%2;
            if(s >= 2)  c = 1;
            else  c = 0;
            rst.append((char)(r+48));
            i++;
        }
        if(c == 1){
            rst.append('1');
        }
        return new String(rst.reverse());

    }
}
