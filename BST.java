class BST {
  
  static class Node{
    int key;
    Node left, right;
    Node(int data) {
      this.key = data;
      this.left = this.right = null;
    }
  }
  Node root;
  public void inorder(Node root){
    if(root == null) {
      return;
      
    }
      
    inorder(root.left);
    System.out.print(root.key + "\t");
    inorder(root.right);
    
  }
  
  public Node insert(Node root, int key){
    if(root == null){
      return new Node(key);
    }
    
    if(root.key < key){
      root.right = insert(root.right, key);
    }
    else if(root.key > key){
      root.left = insert(root.left, key);
    }
    
    return root;
  }
  
  public Node deleteNode(Node root, int key){
    
    if(root == null){
      return root;
    }
    
    if(root.key > key){
      root.left = deleteNode(root.left, key);
      return root;
    }
    else if (root.key < key) {
      root.right = deleteNode(root.right, key);
      return root;
    }
    else if (root.key == key)
    {
      if(root.right == null){
        Node temp = root.left;
        return temp;
      }
      else if(root.left == null){
        Node temp = root.right;
        return temp;
      }
      else{
        Node succParent = root;
        Node succ = root.right;
        while(succ.left != null){
          succParent = succ;
          succ = succ.left;
        }
        
        if(succParent != root){
          succParent.left = succ.right;
        }
        else{
          succParent.right = succ.right;
        }
        
        root.key = succ.key;
      }
      
    }
    
    return root;
  }
  
  public static void main(String args[]) {
    System.out.println("Binary Search Tree Implementation :: ");
    BST tree = new BST();
 
        /* Let us create following BST
                  50
               /     \
              30      70
             /  \    /  \
           20   40  60   80 */
      tree.root = tree.insert(tree.root, 50);
      tree.insert(tree.root, 30);
      tree.insert(tree.root, 20);
      tree.insert(tree.root, 40);
      tree.insert(tree.root, 70);
      tree.insert(tree.root, 60);

      System.out.print("Original BST: ");
      tree.inorder(tree.root);

      System.out.println("\n\nDelete a Leaf Node: 20");
      tree.root = tree.deleteNode(tree.root, 20);
      System.out.print("Modified BST tree after deleting Leaf Node:\n");
      tree.inorder(tree.root);

      System.out.println("\n\nDelete Node with single child: 70");
      tree.root = tree.deleteNode(tree.root, 70);
      System.out.print("Modified BST tree after deleting single child Node:\n");
      tree.inorder(tree.root);

      System.out.println("\n\nDelete Node with both child: 50");
      tree.root = tree.deleteNode(tree.root, 50);
      System.out.print("Modified BST tree after deleting both child Node:\n");
      tree.inorder(tree.root);
  }
}



// Output:

// Binary Search Tree Implementation :: 
// Original BST: 20	30	40	50	60	70	

// Delete a Leaf Node: 20
// Modified BST tree after deleting Leaf Node:
// 30	40	50	60	70	

// Delete Node with single child: 70
// Modified BST tree after deleting single child Node:
// 30	40	50	60	

// Delete Node with both child: 50
// Modified BST tree after deleting both child Node:
// 30	40	60	
