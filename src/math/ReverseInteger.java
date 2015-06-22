package math;


/**
 * 
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * click to show spoilers.
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * 
 * 
 * 
 * @author yunhe
 *
 */
public class ReverseInteger {
    public int reverse1(int x) {
        if(x == 0){
            return 0;
        }
        Boolean isNeg = false;
        String str = String.valueOf(x);
        String rst = "";
        if(str.charAt(0) == '-'){
            isNeg = true;
            str = str.substring(1);
        }
        int num = 0;
        while(str.length() != 0){
            if(str.charAt(0) == '0'){
                num++;
            }
            else
                num = 0;
            String temp = rst;
            int bef = 0;
            if(temp != ""){
                bef = Integer.valueOf(temp);
            }
            rst = str.substring(0,1) + temp;
            int aft = Integer.valueOf(rst);
            if(aft < bef){
                return 0;
            }
            str = str.substring(1);
        }
        rst = rst.substring(num);
        int ret = Integer.valueOf(rst);
        if(isNeg == true){
            return (-1)*ret;
        }
        return ret;
    }
    
    public int reverse2(int x) {
        int sign = x < 0 ? -1 : 1;
        if(x == Integer.MIN_VALUE)  return 0;
        x = Math.abs(x);
        int rst = 0;
        while(x != 0){
            if(rst != 0 && Integer.MAX_VALUE/rst < 10 || Integer.MAX_VALUE - rst*10 < x%10)
                return 0;
            rst = rst*10 + x%10;
            x = x/10;
        }
        return rst*sign;
    }
    
    public static void main(String[] argv){
    	System.out.println((int)9/10);
    	ReverseInteger ri = new ReverseInteger();
    	System.out.println(ri.reverse1(6324351));
    }
}
