package math;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int length = 0;
        int height = 0;
        
        if(C > E && A < G){
            if(C < G)  length = Math.min(C - E, C - A);
            else  length = Math.min(G - E, G - A);
        }
        if(D > F && B < H){
            if(D < H)  height = Math.min(D - F, D - B);
            else height = Math.min(H - F, H - B);
        }
        
        int cm_area = length*height;
        return (C-A)*(D-B) + (G-E)*(H-F) - cm_area;
    }
    
    public static void main(String[] argv){
    	RectangleArea ra = new RectangleArea();
    	int rst = ra.computeArea(-2, -2, 2, 2, 1, -3, 3, -1);
    	System.out.print(rst);
    }
}
