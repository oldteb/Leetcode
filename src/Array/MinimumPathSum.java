package Array;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
        	return 0;
        }
        
        int m = grid[0].length;
        int n = grid.length;
        
        int sum = init(grid, n, m);
        if(n == 1){
        	return sum;
        }
        else{
        	return help(grid,1,n,m);
        }
    }

	int help(int[][] grid, int i, int n, int m) {
		int j = 0;
		grid[i][0] += grid[i-1][0];
		for(j = 1; j < m; j++){
			grid[i][j] += Math.min(grid[i][j-1], grid[i-1][j]);
		}
		int sum = grid[i][j-1];
		
		if(i == n-1){
			return sum;
		}
		else{
			return help(grid, i+1, n, m);
		}
	}
	
	int init(int[][] grid, int n, int m){
		int sum = 0;
		for(int i = 0; i < m; i++){
			grid[0][i] += sum;
			sum = grid[0][i];
		}
		return sum;
		
	}


	public static void main(String argv[]){
		int[][]grid = {{1,2},{5,6},{1,1}};
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.minPathSum(grid));
	}
}
