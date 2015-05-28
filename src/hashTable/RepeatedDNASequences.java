package hashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> rst = new ArrayList<String>();
        if(s == null || s.length() <= 10){
            return rst;
        }
        
        Map<Integer, Node> map = new HashMap<Integer, Node>();
        for(int i = 0; i < s.length()-9; i++){
            String sub = subStr(s,i);
            int key = sub.hashCode();
            Node node = null;
            if(map.containsKey(sub) == true){
                node = map.get(key);
                int flag = 0;
                while(true){
                    if(sub.equals((String)subStr(s,node.index))){
                        node.times++;
                        if(node.times == 2){
                            rst.add(sub);
                        }
                        flag = 1;
                        break;
                    }
                    if(node.next != null)  node = node.next;
                    else break;
                }
                if(flag == 0){
                    node.next = new Node(i,1);
                }
            }
            else{
                node = new Node(i,1);
                map.put(key,node);
            }
        }
        
        return rst;
    }
    
    String subStr(String s, int i){
        String sub;
        if(i+9 == s.length()-1){
            sub = s.substring(i);
        }
        else{
            sub = s.substring(i,i+10);
        }
        return sub;
    }
    
    class Node{
        int index = 0;
        int times = 0;
        Node next = null;
        Node(int idx, int t){
            this.index = idx;
            this.times = t;
        }
    }
}
