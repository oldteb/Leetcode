package Array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        if(k < 1 || n < 1 || n > 45)  return rst;
        List<Integer> buf = new ArrayList<Integer>(k+1);
        dfs(k, n, rst, 1, 1, 0, buf);
        return rst;
    }
    
    void dfs(int k, int n, List<List<Integer>> rst, int idx, int lvl, int sum, List<Integer> buf){
        if(lvl == k+1){
            if(sum == n){
                List<Integer> temp = new ArrayList<Integer>();
                temp.addAll(buf);
                rst.add(temp);
            }
            return;
        }
        for(int i = idx; i <= 9; i++){
            if(sum + i > n)  return;
            buf.add(i);
            dfs(k,n,rst,i+1,lvl+1,sum+i, buf);
            buf.remove(buf.size()-1);
        }
    }
}
