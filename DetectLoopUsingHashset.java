import java.util.*;

public class DetectLoopUsingHashset {
    Node head;
    class Node {
        int key;
        Node next;
        Node(int k) {
        key = k;
        next = null;
            
        }
        
    }
    
    
    
    public void push(int ele) {
        Node temp = new Node(ele);
        temp.next = head;
        head = temp;
    }
    
    public boolean isLoopExists(Node head) {
        Node temp = head;
        HashSet<Node> hset = new HashSet<Node>();
        while(temp != null) {
            if (hset.contains(temp)){
                return true;
            }
            
            hset.add(temp);
            temp = temp.next;
        }
        
        return false;
        
        
    }
    
    // public void printList(Node head) {
    //     Node temp = head;
    //     while(temp != null) {
    //         System.out.print(temp.key + " ");
    //         temp = temp.next;
    //     }
    // }
    public static void main(String[] args) {
        DetectLoopUsingHashset llist = new DetectLoopUsingHashset();
        llist.push(12);
        llist.push(45);
        llist.push(24);
        llist.push(47);
        llist.push(97);
        //llist.head.next.next.next.next.next = llist.head;
        System.out.println("Printing the list :: ");
        // llist.printList(llist.head);
        if (llist.isLoopExists(llist.head)) {
            System.out.print("Loop Exists in LinkedList");
        }
        else {
            System.out.print("Loop doesn't exists in the LinkedList");
        }
        
        
    }
    
}

