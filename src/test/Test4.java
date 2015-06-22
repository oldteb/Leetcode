package test;

import java.util.Stack;
import java.util.concurrent.Future;


public class Test4 {
    public int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
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
    
    public static void main(String[] args) {
		Test4 t = new Test4();
		System.out.println(t.reverse(Integer.MIN_VALUE));
	}
}






