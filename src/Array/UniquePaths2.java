package Array;

public class UniquePaths2 {
    public int uniquePaths(int m, int n) {
    	if(m  == 0 && n == 0){
    		return 0;
    	}
    	int[][] buf = new int[m][n];
    	
    	for(int i = 0; i < m; i++){
    		if(i == 0){
    			for(int k = 0; k < n; k++){
    				buf[0][k] = 1;
    			}
    			continue;
    		}
    		buf[i][0] = 1;
    		for(int j = 1; j < n; j++){
    			buf[i][j] = buf[i-1][j] + buf[i][j-1];
    		}
    	}
    	
    	return buf[m-1][n-1];
    }
    
    public static void main(String argv[]){
    	UniquePaths2 up = new UniquePaths2();
    	System.out.println(up.uniquePaths(30,30));
    }
}
