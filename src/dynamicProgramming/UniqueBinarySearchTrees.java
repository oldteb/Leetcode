package dynamicProgramming;

public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if(n == 0){
        	return 0;
        }
    	int[] buf = new int[n+1];
    	buf[0] = 1;
    	buf[1] = 1;
    	int i = 2;
    	while(i <= n){
    		for(int j = 0; j < i; j++){
    			buf[i] += buf[j]*buf[i-1-j];
    		}
    		i++;
    	}
    	return buf[n];
    }

}
