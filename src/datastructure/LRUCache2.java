package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache2 {
	
	Map<Integer, Record> cache = new HashMap<Integer, Record>();
	int cap;
	int num = 0;
	Record head = null;
	Record last = null;
	
    public LRUCache2(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key) == false)  return -1;
        else{
        	update(key);
        	return cache.get(key).value;
        }
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key) == true){
        	cache.get(key).setVal(value);
        	update(key);
        }
        else{
        	if(num >= cap){
        		Record temp = last;
        		nodeRmv(last);
        		cache.remove(temp.key);
        		num--;
        	}
        	Record rd = new Record(key,value,null,head);
        	head = rd;
        	if(head.next == null)  last = rd;
        	else head.next.pre = head;
        	cache.put(key,rd); 
        	num++;   	
        }
    }
    
    void update(int key){
    	Record rcd = cache.get(key);
    	nodeRmv(rcd);
    	rcd.pre = null;
    	rcd.next = head;
    	head = rcd;
    	if(head.next == null)  last = rcd;
    	else head.next.pre = head;
    }
    
    void nodeRmv(Record rcd){
    	if(rcd == null)  return;
    	if(rcd.pre == null && rcd.next == null){    // head & tail
    		head = null;
    		last = null;
    	}
    	else if(rcd.pre == null){
    		head = head.next;
    		head.pre = null;
    	}
    	else if(rcd.next == null){
    		last = last.pre;
    		last.next = null;
    	}
    	else{
    		rcd.pre.next = rcd.next;
    		rcd.next.pre = rcd.pre;
    	}
    }
    	
    
    class Record{
    	int key;
    	int value;
    	Record pre = null;
    	Record next = null;
    	Record(int key, int value, Record pre, Record next){
    		this.key = key;
    		this.value = value;
    		this.pre = pre;
    		this.next = next;
    	}
    	
    	void setVal(int value){
    		this.value = value;
    	}
    }
    
    public static void main(String argv[]){
    	LRUCache2 lruc = new LRUCache2(1);
    	lruc.set(2,1);
//    	lruc.set(3,1);
//    	lruc.set(4,1);
    	//lruc.get(2);
//    	lruc.set(6,1);
//    	lruc.set(7,1);
    	System.out.println(lruc.get(2));
    	
    }
}
