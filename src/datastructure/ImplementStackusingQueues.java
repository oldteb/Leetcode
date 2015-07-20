package datastructure;

import java.util.LinkedList;


/**
 * 
 * Implement the following operations of a stack using queues.
 * 
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * 
 * <p>
 * <h2>Notes:</h2>
 * You must use only standard operations of a queue -- which means only 
 * push to back, peek/pop from front, size, and is empty operations are 
 * valid. Depending on your language, queue may not be supported nativ-
 * ely. You may simulate a queue by using a list or deque (double-ended
 * queue), as long as you use only standard operations of a queue. You 
 * may assume that all operations are valid (for example, no pop or top 
 * operations will be called on an empty stack).</p>
 * 
 * 
 * @author yunhe
 *
 */
public class ImplementStackusingQueues {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    
    // Push element x onto stack.
    public void push(int x) {
        queue.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        for(int i = 0; i < queue.size()-1; i++){
            queue.offer(queue.poll());
        }
        queue.poll();
    }

    // Get the top element.
    public int top() {
        for(int i = 0; i < queue.size()-1; i++){
            queue.offer(queue.poll());
        }
        int top = queue.peek();
        queue.offer(queue.poll());
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue.size()==0 ? true : false;
    }
}
