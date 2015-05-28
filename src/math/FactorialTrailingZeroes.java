package math;

public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        if( n <= 0 ) return 0;
        int count = 0;
        for(int i = 5; n/i > 0;){
        	count += n/i;
        	n = n/i;
        }
        Math.m
        return count;
    }
}
