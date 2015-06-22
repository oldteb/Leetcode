package datastructure;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * 
 * 
 * @author yunhe
 *
 */

public class MinStack {
    Stack<Integer> stackElm = new Stack<Integer>();
    Stack<Integer> stackMin = new Stack<Integer>();
    
    public void push(int x) {
        stackElm.push(x);
        if(stackMin.size() != 0 && stackMin.peek() < x)
            stackMin.push(stackMin.peek());
        else
            stackMin.push(x);
    }

    public void pop() {
        if(stackElm.size() != 0){
            stackElm.pop();
            stackMin.pop();
        }
    }

    public int top() {
        return stackElm.size() == 0 ? -1 : stackElm.peek();
    }

    public int getMin() {
        return stackMin.size() == 0 ? -1 : stackMin.peek();
    }
}
