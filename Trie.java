// class which implements insert, search, remove and display operations of TRIE
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
    
    static boolean isEmpty(TrieNode ptr){
        for(int i=0 ; i < ALPHABET_SIZE; i++){
            if(ptr.children[i] != null){
                return false;
            }
        }
        return true;
    }
    
    static TrieNode remove(TrieNode root, String key, int depth) {
        if(root == null){
            return root;
        }
        
        if(depth == key.length()){
            if(root.isEndOfWord){
                root.isEndOfWord = false;
            }
            if(isEmpty(root)){
            root = null;
                
            }
            return root;
        }
        int index = key.charAt(depth) - 'a';
        root.children[index] = remove(root.children[index], key, depth + 1);
        
        if(isEmpty(root) && root.isEndOfWord == false)
        {
            root = null;
        }
        
        return root;
    }
    
    static void display(TrieNode ptr, char[] str, int depth){
        if(ptr.isEndOfWord){
            
            for(int k=depth; k < str.length; k++){
                str[k] = 0;
            }
            System.out.println(str);
        }
        
        for(int i=0; i < ALPHABET_SIZE; i++){
            if(ptr.children[i] != null){
                str[depth] = (char) (i + 'a');
                display(ptr.children[i], str, depth + 1);
            }
            
        }
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
            System.out.println("teach --- " + output[1]);
        else System.out.println("teach --- " + output[0]);
         
        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);
         
        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);
         
        if(search("at") == true)
            System.out.println("at --- " + output[1]);
        else System.out.println("at --- " + output[0]);
        
        remove(root, "at", 0);
        if(search("at") == true)
            System.out.println("at --- " + output[1]);
        else System.out.println("at --- " + output[0]);
        
        char str[] = new char[100];
        display(root, str, 0);
    }
    
    
}

// teach --- Present in trie
// these --- Not present in trie
// their --- Not present in trie
// at --- Present in trie
// at --- Not present in trie
// a
// business
// dont
// like
// school
// secrets
// teach
// they
// virgin
