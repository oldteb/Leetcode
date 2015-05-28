package Array;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
    	if( m < 1 || n < 1){
    		return 0;
    	}
    	return help(0, 0, m, n);	
    }
    
    int help(int row, int col, int m, int n){
    	int count = 0;
    	if(row == m-1 && col == n-1){
    		return 1;
    	}
    	if(row > m-1 || col > n-1){
    		return 0;
    	}
    	
    	if(row < m-1){
    		count += help(row+1,col,m,n);
    	}
    	if(col < n-1){
    		count += help(row,col+1,m,n);
    	}
    	return count;
    }

    public static void main(String argv[]){
    	UniquePaths up = new UniquePaths();
    	System.out.println(up.uniquePaths(23,12));
    }
}


