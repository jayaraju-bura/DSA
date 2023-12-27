import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNodeDeletion {
  
    static class Node {
      int key;
      Node left, right;
      public Node(int data){
        this.key = data;
      }
    }
    
    static void inorder(Node root){
      if(root == null){
        return;
      }
      inorder(root.left);
      System.out.print(root.key + "\t");
      inorder(root.right);
      
    }
    
    static Node deletion(Node root, int key){
      System.out.println("inside deletion method -> key to be deleted :: " + key);
      if(root == null){
        return null;
      }
      
      if(root.left == null && root.right == null){
        return root.key == key ? root : null;
      }
      
      Node keyNode = null, temp = null, last = null;
      
      Queue<Node> q = new LinkedList<Node>();
      q.offer(root);
      
      while(!q.isEmpty()){
        temp = q.poll();
        
        if(temp.key == key){
          System.out.println("inside deletion method -> key to be deleted founded ::  " + temp.key);
          keyNode = temp;
        }
        
        if(temp.left != null){
          last = temp;
          q.offer(temp.left);
        }
        
        if(temp.right != null){
          last = temp;
          q.offer(temp.right);
        }
      }
      
      if(keyNode != null){
        keyNode.key = temp.key;
        
        if(last.right == temp){
          last.right = null;
        }
        
        if(last.left == temp){
          last.left = null;
        }
      }
      
      return root;
    }
    
    
    public static void main(String[] args) {
      
      Node root = new Node(9);
      root.left = new Node(2);
      root.left.left = new Node(4);
      root.left.right = new Node(7);
      root.right = new Node(8);

      System.out.print(
          "Inorder traversal before deletion : ");
      inorder(root);
      System.out.println();

      int key = 7;
      root = deletion(root, key);

      System.out.print(
          "Inorder traversal after deletion : ");
      inorder(root);
      System.out.println();
      
  }
}



 


// Output:

// Inorder traversal before deletion : 4	2	7	9	8	
// inside deletion method -> key to be deleted :: 7
// inside deletion method -> key to be deleted founded ::  7
// Inorder traversal after deletion : 4	2	9	8	
