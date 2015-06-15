package math;

public class CountPrimes {
    public int countPrimes(int n) {
        int[] primeTable = new int[n];
        for(int i = 2; i < n; i++){
            if(primeTable[i] != 0)  continue;
            for(int j = 2; i*j < n; j++){
                primeTable[i*j] = 1;
            }
        }
        int count = 0;
        for(int i = 2; i < n; i++)
            if(primeTable[i] == 0)  count++;
        return count;
    }
}
