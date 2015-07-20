package datastructure;

import java.util.Stack;


/**
 * 
 * Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * <p>
* <h2>Notes:</h2>
 * You must use only standard operations of a stack -- which means only push to top, 
 * peek/pop from top, size, and is empty operations are valid.
 *
 * Depending on your language, stack may not be supported natively. You may simulate 
 * a stack by using a list or deque (double-ended queue), as long as you use only 
 * standard operations of a stack.
 * 
 * You may assume that all operations are valid (for example, no pop or peek operations 
 * will be called on an empty queue).
 * </p>
 * 
 * 
 * @author yunhe
 *
 */
public class ImplementQueueusingStacks {
    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(outStack.size() == 0){
            transfer();
        }
        outStack.pop();
    }

    // Get the front element.
    public int peek() {
        if(outStack.size() == 0){
            transfer();
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if(inStack.size() + outStack.size() == 0)  return true;
        else return false;
    }
    
    void transfer(){
        while(inStack.size() != 0){
            outStack.push(inStack.peek());
            inStack.pop();
        }
    }
}
