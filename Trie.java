
public class Trie {
    static final int ALPHABET_SIZE = 26;
    static class TrieNode {
        
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;
        TrieNode() {
            for(int i=0; i<ALPHABET_SIZE; i++) {
                children[i] = null;
            }
            isEndOfWord = false;
        }
    }
        
    static TrieNode root;
    static void insert(String key) {
        int len = key.length();
        TrieNode pcrawl = root;
        for(int i=0; i < len; i++){
            int index = key.charAt(i) - 'a';
            if(pcrawl.children[index] != null){
                pcrawl = pcrawl.children[index];
            }
            else{
                pcrawl.children[index] = new TrieNode();
                pcrawl = pcrawl.children[index];
            }
        }
        pcrawl.isEndOfWord = true;
    }
    
    static boolean search(String key) {
        int len = key.length();
        TrieNode pcrawl = root;
        for(int i=0; i < len; i++){
            int index = key.charAt(i) - 'a';
            if(pcrawl.children[index] != null){
                pcrawl = pcrawl.children[index];
            }
            else{
               return false;
            }
        }
        return (pcrawl.isEndOfWord == true);
        
    }
    
    public static void main(String args[]) {
        String keys[] = {"like", "a", "virgin", "secrets", "they",
                         "dont", "teach", "business", "at", "school"};
      
        String output[] = {"Not present in trie", "Present in trie"};
      
      
        root = new TrieNode();
      
        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            insert(keys[i]);
      
        // Search for different keys
        if(search("teach") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(search("at") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }
    
    
}


// the --- Present in trie
// these --- Not present in trie
// their --- Not present in trie
// thaw --- Present in trie
