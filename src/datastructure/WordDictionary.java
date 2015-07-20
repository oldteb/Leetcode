package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * <p>Design a data structure that supports the following two operations:
 * 
 * <p>void addWord(word)
 * <p>bool search(word)
 * <p>search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * 
 * <p>For example:
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * <p>Note:
 * You may assume that all words are consist of lowercase letters a-z.
 *  
 * 
 * @author yunhe
 */
public class WordDictionary {
    WordNode root = new WordNode('0');
    

    // Adds a word into the data structure.
    public void addWord(String word) {
        if(word == null)  return;
        addWordRec(root, word, 0);
    }
    
    void addWordRec(WordNode wn, String str, int idx){
        if(idx >= str.length()){
            wn.isLeaf = true;
            return;
        }
        char tar = str.charAt(idx);
        WordNode temp = null;
        for(WordNode wnode : wn.children){
            if(wnode.c == tar){
                temp = wnode;
                break;
            }
        }
        if(temp == null){
            temp = new WordNode(tar);
            wn.children.add(temp);
        }
        
        addWordRec(temp, str, idx+1);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(word == null)  return false;
        LinkedList<WordNode> queue = new LinkedList<WordNode>();
        for(WordNode wn : root.children){
            queue.offer(wn);
        }
        int idx = 0;
        int count = 0;
        
        while(idx < word.length() && queue.size() != 0){
            count = queue.size();
            char tar = word.charAt(idx);
            if(idx == word.length()-1){
                for(int i = 0; i < count; i++){
                    WordNode wn = queue.poll();
                    if((tar == '.' || wn.c == tar) && wn.isLeaf == true){
                        return true;
                    }
                }
            }
            else{
                for(int i = 0; i < count; i++){
                    WordNode wn = queue.poll();
                    if(tar == '.' || wn.c == tar){
                        for(WordNode wnode : wn.children)
                            queue.offer(wnode);
                    }
                }
                idx++;
            }
        }
        
        return false;
        
    }
    
    
    class WordNode{
        char c;
        boolean isLeaf = false;
        List<WordNode> children;
        
        WordNode(char c){
            this.c = c;
            children = new ArrayList<WordNode>();
        }
        
    }
}
//Your WordDictionary object will be instantiated and called as such:
//WordDictionary wordDictionary = new WordDictionary();
//wordDictionary.addWord("word");
//wordDictionary.search("pattern");
