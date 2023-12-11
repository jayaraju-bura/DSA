public class BTree {
    private int T;
    public class Node {
        int n;
        int keys[] = new int[2*T - 1];
        Node child[] = new Node[2*T];
        boolean leaf = true;
        
        public int Find(int k){
            for(int i=0; i<this.n; i++){
                if(this.keys[i] == k){
                    return i;
                }
            }
            return -1;
        }
    }
    private Node root;
    
    public BTree(int t){
        T = t;
        root = new Node();
        root.n = 0;
        root.leaf = true;
    }
    
    private void split(Node x, int pos, Node y){
        Node z = new Node();
        z.n = T-1;
        z.leaf = y.leaf;
        for(int j=0; j<T-1; j++) {
            z.keys[j] = y.keys[j+T];
        }
        
        if(!y.leaf) {
            for(int j=0; j<T ; j++){
                z.child[j] = y.child[j+T];
                
            }
        }
        
        for(int j=x.n; j>=pos+1; j--){
            x.child[j+1] = x.child[j];
        }
        x.child[pos + 1] = z;
        
        for(int j=x.n-1; j>=pos; j--){
            x.keys[j+1] = x.keys[j];
        }
        x.keys[pos] = y.keys[T-1];
        x.n = x.n+1;
    }
    
    public void Insert(final int key) {
        Node r = root;
        if (r.n == 2 * T - 1) {
          Node s = new Node();
          root = s;
          s.leaf = false;
          s.n = 0;
          s.child[0] = r;
          split(s, 0, r);
          insertValue(s, key);
        } else {
          insertValue(r, key);
        }
    }

  // Insert the node
    final private void insertValue(Node x, int k) {
        if (x.leaf) {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.keys[i]; i--) {
                x.keys[i + 1] = x.keys[i];
                
            }
            x.keys[i + 1] = k;
            x.n = x.n + 1;
            
        }
        else {
            int i = 0;
            for (i = x.n - 1; i >= 0 && k < x.keys[i]; i--) {
                
            }
          
            i++;
            Node tmp = x.child[i];
            if (tmp.n == 2 * T - 1) {
                split(x, i, tmp);
                if (k > x.keys[i]) {
                    i++;
                    
                }
                
            }
            insertValue(x.child[i], k);
            
        }
        
    }
    
    
    public void show(){
        show(root);
    }
    
    private void show(Node x){
        assert (x == null);
        for(int i=0; i<x.n; i++){
            System.out.println(x.keys[i] + "");
        }
        if(!x.leaf){
            for(int j=0; j<x.n+1; j++){
                show(x.child[j]);
            }
        }
    }
    
    private Node search(Node x, int key){
        int itr = 0;
        if (x == null){
            return null;
        }
        for(itr = 0; itr < x.n; itr++){
            if(key < x.keys[itr]) {
                break;
            }
            
            if (key == x.keys[itr]) {
                return x;
            }
        }
        
        if(x.leaf){
            return null;
        }
        else {
            return search(x.child[itr], key);
        }
        
    }
    
    public boolean contain(int key){
        if (this.search(root, key) != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public static void main(String[] args) {
        BTree b = new BTree(3);
        b.Insert(8);
        b.Insert(9);
        b.Insert(10);
        b.Insert(11);
        b.Insert(15);
        b.Insert(20);
        b.Insert(17);
        b.show();

        if (b.contain(11)) {
          System.out.println("\nfound");
        } else {
          System.out.println("\nnot found");
        }
        
    }
}



// 10
// 8
// 9
// 10
// 11
// 15
// 11
// 15
// 17
// 20

// found
