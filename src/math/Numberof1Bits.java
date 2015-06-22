package math;

public class Numberof1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int mask = 1;
        int count = 0;
        for(int i = 0; i < 32; i++){
            if((n & (mask<<i)) != 0)  count++;
        }
        return count;
    }
}
