package datastructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 *
 * Note: 
 * You may assume k is always valid, 1 ¡Ü k ¡Ü array's length.
 * 
 * 
 * @author yunhe
 *
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0)  return -1;
        Comparator<Integer> comp = new MyIntegerComparator();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k,comp);
        for(Integer i : nums){
            pq.offer(i);
        }
        for(int i = 1; i < k; i++){
            pq.poll();
        }
        
        return pq.poll();
    }
    
    
    class MyIntegerComparator implements Comparator<Integer>{
        
        @Override
        public int compare(Integer x, Integer y){
            if(x == y)  return 0;
            else return x > y ? -1 : 1;
        }
        
    }
}
