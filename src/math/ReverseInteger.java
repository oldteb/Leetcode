package math;

public class ReverseInteger {
    public int reverse(int x) {
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
    
    public static void main(String[] argv){
    	System.out.println((int)9/10);
    	ReverseInteger ri = new ReverseInteger();
    	System.out.println(ri.reverse(6324351));
    }
}
