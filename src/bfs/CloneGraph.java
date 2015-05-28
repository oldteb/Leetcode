package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
        	return null;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.push(node);
        map.put(node,new UndirectedGraphNode(node.label));
        
        while(!queue.isEmpty()){
        	UndirectedGraphNode cur = queue.pop();
        	for(Iterator<UndirectedGraphNode> iter = cur.neighbors.iterator(); iter.hasNext() ; ){
        		UndirectedGraphNode temp = iter.next();
        		if(map.containsKey(temp)){
        			map.get(cur).neighbors.add(map.get(temp));
        		}
        		else{
        			UndirectedGraphNode newnode = new UndirectedGraphNode(temp.label);
        			map.put(temp, newnode);
        			queue.add(temp);
        			map.get(cur).neighbors.add(map.get(temp));
        		}
        	}
        }

        return map.get(node);
    }
}



//Definition for undirected graph.
class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;
	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
