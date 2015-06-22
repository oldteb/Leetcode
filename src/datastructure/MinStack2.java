package datastructure;

import java.util.ArrayList;
import java.util.List;

public class MinStack2 {
    List<Integer> list = new ArrayList<Integer>();
    List<Integer> min = new ArrayList<Integer>();
    
    public void push(int x) {
        if(list.size()==0){
            min.add(0);
        }
        else if(list.get(min.get(min.size()-1)) > x){
            min.add(list.size());
        }
        list.add(x);
    }

    public void pop() {
        if(list.size() != 0){
            if(list.size()-1 == min.get(min.size()-1)){
                min.remove(min.size()-1);
            }
            list.remove(list.size()-1);
        }
    }

    public int top() {
        if(list.size() != 0){
            return list.get(list.size()-1);
        }
        return 0;
    }

    public int getMin() {
        if(list.size() != 0){
            return list.get(min.get(min.size()-1));
        }
        return 0;
    }
    
    
    public static void main(String argv[]){
    	MinStack2 ms = new MinStack2();
    	ms.push(1);
    	ms.push(2);
    	ms.push(3);
    	ms.push(4);
    	ms.push(5);
    	ms.push(6);
    	System.out.println("min size:" + ms.min.size());
    	System.out.println(ms.getMin());
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	ms.pop();
    	System.out.println(ms.getMin());
    	ms.pop();
    	ms.pop();
    	System.out.println(ms.getMin());
    	System.out.println(ms.top());
    	System.out.println("min size:" + ms.min.size());
    }
}
