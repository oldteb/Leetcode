package math;

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE)  return 1;
            else  return 0;
        }
        if(dividend == 0)  return 0;
        char sign = '+';
        if((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = '-';
        int d1;
        int flag = 0;
        if(dividend == Integer.MIN_VALUE){
            if(divisor == -1)  return Integer.MAX_VALUE;
            d1 = Integer.MAX_VALUE;
            flag = 1;
        }
        else 
            d1 = Math.abs(dividend);
        int d2 = Math.abs(divisor);
        if(d1 < d2)  return 0;
        String s1 = Integer.toString(d1);
        int ans = help(s1,d2,flag);
        if(sign == '-'){
            ans = 0 - ans;
        }
        
        return ans;
    }
    
    int help(String s1, int d2, int flag){
        int i = 0;
        int rest = 0;
        StringBuffer ans = new StringBuffer();
        StringBuffer sb1 = new StringBuffer(s1);
        int h = 0;
        while(sb1.length() != 0){
            int d = 1;
            while(d <= sb1.length() && Integer.parseInt(sb1.substring(0,d)) < d2){
                if(h < 1)  ans.append('0');
                d++;  h--;
            }
            if(d > sb1.length())  break;
            rest = Integer.parseInt(sb1.substring(0,d));
            int j = 0;
            for(; rest >= d2; j++){
                rest -= d2;
            }
            ans.append((char)(j+48));
            sb1.delete(0,d);
            h = 0;
            if(rest != 0){
                String temp = Integer.toString(rest);
                h = temp.length();
                sb1.insert(0,temp.toCharArray());
            }
        }
        int rst = Integer.parseInt(ans.toString());
        if(flag == 1){
            int m = 0;
            if(sb1.length() == 0)  m=0;
            else m = Integer.parseInt(sb1.toString());
            if(m+1 >= d2)  rst++;
        }
        return rst;
    }
    
    public static void main(String[] argv){
    	DivideTwoIntegers dti = new DivideTwoIntegers();
    	int ans = dti.divide(-1060849722, 99958928);
    	System.out.print(ans);
    	
    }
}
