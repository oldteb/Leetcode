package dynamicProgramming;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n < 0)  return 0;
        else if(n == 1)  return 1;
        else if(n == 2)  return 2;
        
        int[] arr1 = new int[n+1];
        int[] arr2 = new int[n+1];
        arr1[1] = 1;
        arr1[2] = 1;
        arr2[1] = 0;
        arr2[2] = 1;
        for(int i = 3; i <= n; i++){
            arr1[i] = arr1[i-1] + arr2[i-1];
            arr2[i] = arr1[i-1];
        }

        return arr1[n] + arr2[n];
    }
}
