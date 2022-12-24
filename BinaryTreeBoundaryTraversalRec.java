class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class BinaryTreeBoundaryTraversalRec {
    Node root;
    void printLeftBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            System.out.println(root.data + " ");
            printLeftBoundary(root.left);
        }
        else if (root.right != null) {
            System.out.println(root.data + " ");
            printLeftBoundary(root.right);
        }
        
    }
    void printRightBoundary(Node root) {
        if (root == null) {
            return;
        }
        if (root.right != null) {
            printRightBoundary(root.right);
            System.out.println(root.data + " ");
            
        }
        else if (root.left != null) {
             printRightBoundary(root.left);
             System.out.println(root.data + " ");
           
        }
        
        
    }
    void printLeaves(Node root) {
        if (root == null) {
            return;
        }
        printLeaves(root.left);
        if (root.left == null && root.right == null) {
            System.out.println(root.data + " ");
        }
        printLeaves(root.right);
        
    }
    void printBoundary(Node root) {
        
        if (root == null) {
            return;
        }
        System.out.println("Boundary Traversal of given binary tree : \n" + root.data + " ");
        printLeftBoundary(root.left);
        printLeaves(root.left);
        printLeaves(root.right);
        printRightBoundary(root.right);
        
        
        
    }
    public static void main(String[] args) {
        
        BinaryTreeBoundaryTraversalRec tree = new BinaryTreeBoundaryTraversalRec();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);
        
    }
}

//java -cp /tmp/pFr7tbPRYt BinaryTreeBoundaryTraversal
//Boundary Traversal of given binary tree : 
//20 8 4 
//10 14 
//25 
//22 
