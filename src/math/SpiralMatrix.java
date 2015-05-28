package math;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> rst = new ArrayList<Integer>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0 ) return rst;
        int i = 0, j = 0;
        for(int k = 0; k < Math.min(Math.ceil(matrix.length/2.0),Math.ceil(matrix[0].length/2.0)); k++){
            i = k;  j = k;
            int n = 0;
            for(n = 0; n < matrix[0].length-2*k-1; n++)
                rst.add(matrix[i][j+n]);
            j += n;
            for(n = 0; n < matrix.length-2*k-1; n++)
                rst.add(matrix[i+n][j]);
            i += n;
            for(n = 0; n < matrix[0].length-2*k-1; n++)
                rst.add(matrix[i][j-n]);
            j -= n;
            for(n = 0; n < matrix.length-2*k-1; n++)
                rst.add(matrix[i-n][j]);
            i -= n;
        }
        if(matrix.length == matrix[0].length && matrix.length%2 == 1)
            rst.add(matrix[matrix.length/2][matrix.length/2]);
        return rst;
    }
    
    public static void main(String[] argv){
    	SpiralMatrix sm = new SpiralMatrix();
    	int[][] matrix = {{2,3}};
    	System.out.println("haha");
    	List<Integer> list = sm.spiralOrder(matrix);
    	for(int i : list){
    		System.out.println(i);
    	}
    	
    }
}
