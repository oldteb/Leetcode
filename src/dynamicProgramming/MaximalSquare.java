package dynamicProgramming;
/**
 * 
 * Given a 2D binary matrix filled with 0's and 1's, 
 * find the largest square containing all 1's and return its area.
 * 
 *	For example, given the following matrix:
 *
 *	1 0 1 0 0
 *	1 0 1 1 1
 *	1 1 1 1 1
 *	1 0 0 1 0
 *
 *	Return 4.
 * 
 * 
 * @author yunhe
 *
 */


public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)  return 0;
        int[][] buf = new int[matrix.length][matrix[0].length];
        int max_sqr = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == '0')  buf[i][j] = 0;
                else  buf[i][j] = Math.min(Math.min((i-1<0||j-1<0)?0:buf[i-1][j-1], (i-1<0)?0:buf[i-1][j]), (j-1<0)?0:buf[i][j-1])+1;
                max_sqr = buf[i][j] > max_sqr ? buf[i][j] : max_sqr;
            }
        }
        
        return max_sqr*max_sqr;
    }
}
