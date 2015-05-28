package string;

public class AddBinary {
    public String addBinary(String a, String b) {
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
