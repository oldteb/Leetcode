package hashTable;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if(denominator == 0)  return "";
        if(numerator == 0)  return "0";
        String rst = "";
        int p1 = numerator/denominator;
        if(p1 == 0 && (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)){
            rst += "-";
        }
        rst += Integer.toString(p1);
        if(numerator%denominator == 0)  return rst;
        int rest = numerator%denominator;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while(map.containsKey(rest) == false){
            map.put(rest,i);
            rest *= 10;
            sb.append((char)(Math.abs(rest/denominator)+48));
            rest = rest%denominator;
            if(rest == 0){
                return rst + "." + sb.toString();
            }
            i++;
        }
        sb.insert((int)map.get(rest),'(');
        sb.append(')');
        
        return rst + "." + sb.toString();
    }
    
    public static void main(String[] argv){
    	FractiontoRecurringDecimal frd = new FractiontoRecurringDecimal();
    	System.out.println(frd.fractionToDecimal(-1, -2147483648));
    }
}
