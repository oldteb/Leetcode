package backtrack;

public class NQueensII {
    public int totalNQueens(int n) {
        if(n <= 1)  return n;
        int[] buf = new int[n];
        return help(n,0,buf);
    }
    
    int help(int n, int lvl, int[] buf){
        if(lvl >= n)  return 1;
        int rst = 0;
        for(int j = 0; j < n; j++){
            if(lvl == 0){
                buf[lvl] = j;
                rst += help(n,lvl+1,buf);
            }
            else{
                int m;
                for(m = 0; m < lvl; m++){
                    if(buf[m] == j || Math.abs(lvl-m) == Math.abs(j-buf[m]))  break;
                }
                if(m == lvl){
                    buf[lvl] = j;
                    rst += help(n,lvl+1,buf);
                }
                else  continue;
            }
        }
        return rst;
    }
}
