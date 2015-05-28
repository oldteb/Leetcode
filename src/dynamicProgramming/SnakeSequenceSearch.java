package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SnakeSequenceSearch {
	List<List<Integer>> routeSearch(int[][] A){
		List<List<Integer>> rst = new ArrayList<List<Integer>>();
		if(A == null || A.length == 0 || A[0].length == 0)
			return rst;
		int max = 0;
		
		Object[][] buf = new Object[A.length][A[0].length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				List<List<Integer>> temp = new ArrayList<List<Integer>>();
				if(i-1 >= 0 && Math.abs(A[i-1][j]-A[i][j]) == 1
						&& j-1 >= 0 && Math.abs(A[i][j-1]-A[i][j]) == 1){
					List<List<Integer>> list1 = (List<List<Integer>>)buf[i-1][j];
					List<List<Integer>> list2 = (List<List<Integer>>)buf[i][j-1];
					if(list1.get(0).size() > list2.get(0).size())
						add(A, i, j, i-1, j, buf, temp);
					else if(list1.get(0).size() < list2.get(0).size())
						add(A, i, j, i, j-1, buf, temp);
					else{
						add(A, i, j, i-1, j, buf, temp);
						add(A, i, j, i, j-1, buf, temp);
					}	
				}			
				else if(i-1 >= 0 && Math.abs(A[i-1][j]-A[i][j]) == 1)
					add(A, i, j, i-1, j, buf, temp);
				else if(j-1 >= 0 && Math.abs(A[i][j-1]-A[i][j]) == 1)
					add(A, i, j, i, j-1, buf, temp);
				else{
					List<Integer> t = new ArrayList<Integer>();
					t.add(A[i][j]);
					temp.add(t);
				}
				if(temp.get(0).size() > max)  max = temp.get(0).size();
				buf[i][j] = temp;
			}
		}
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[0].length; j++){
				List<List<Integer>> list = (List<List<Integer>>)buf[i][j];
				if(list.get(0).size() == max){
					for(List<Integer> l : list){
						List<Integer> t = new ArrayList<Integer>();
						t.addAll(l);
						rst.add(t);
					}
				}
			}
		}
		
		return rst;
	}
	
	void add(int[][] A, int i, int j, int m, int n, Object[][] buf, List<List<Integer>> temp){
		List<List<Integer>> list = (List<List<Integer>>)buf[m][n];
		for(List<Integer> l : list){
			List<Integer> t = new ArrayList<Integer>();
			t.addAll(l);
			t.add(A[i][j]);
			temp.add(t);
		}
	}
	
	public static void main(String[] argv){
		SnakeSequenceSearch sss = new SnakeSequenceSearch();
		int[][] A = {{1,2,3},{2,3,4},{3,4,5}};
		List<List<Integer>> rst = sss.routeSearch(A);
		for(List<Integer> l : rst){
			for(Integer i : l){
				System.out.print(i + ",");
			}
			System.out.println();
		}
	}
	
}
