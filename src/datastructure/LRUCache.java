package datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LRUCache {
	
	Map<Integer, Integer> cache = new HashMap<Integer, Integer>();
	List<Record> list = new ArrayList<Record>();
	int cap;
	int num = 0;
	
    public LRUCache(int capacity) {
        this.cap = capacity;
    }
    
    public int get(int key) {
        if(cache.containsKey(key) == false)  return -1;
        else{
        	update(key);
        	return cache.get(key);
        }
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key) == true){
        	cache.put(key, value);
        	update(key);
        }
        else{
        	Record rd = new Record(0,key);
        	for(Record r : list){
        		r.flag++;
        	}
        	list.add(0,rd);
        	cache.put(key, value);  
        	num++;
        	if(num >= cap){
        		int k = list.get(list.size()-1).key;
        		list.remove(list.size()-1);
        		cache.remove(k);
        		num--;
        	}
        }
    }
    
    void update(int key){
    	int tar = 0;
    	for(int i = 0; i < list.size(); i++){
    		if(list.get(i).key == key)  tar = i;
    		else list.get(i).flag++;
    	}
    	Record temp = list.get(tar);
    	temp.flag = 0;
    	list.remove(tar);
    	list.add(0,temp);
    }
    
    class Record{
    	int flag;
    	int key;
    	Record(int flag, int key){
    		this.flag = flag;
    		this.key = key;
    	}
    }
    
    public static void main(String argv[]){
    	LRUCache lruc = new LRUCache(4);
    	lruc.set(2,1);
    	lruc.set(3,1);
    	lruc.set(4,1);
    	lruc.get(2);
    	lruc.set(6,1);
    	System.out.println(lruc.get(3));
    	
    }
}
