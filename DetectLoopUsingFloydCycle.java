import java.util.*;

public class DetectLoopUsingFloydCycle {
    Node head;
  
    
    
    
    public void push(int ele) {
        Node temp = new Node(ele);
        temp.next = head;
        head = temp;
    }
    
    public boolean detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;
        while(slow != null && fast != null && fast.next != null) {
            slow  = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                removeLoop(slow);
                return true;
            }
            
        }
        return false;
        
    }
    
    public void removeLoop(Node loop) {
        System.out.println("loop node:: " + loop.key + "\n");
        Node ptr1 = loop, ptr2 = loop;
        Node prevNode = ptr1;
        int count = 1;
        while(ptr1.next != ptr2) {
            prevNode = ptr1.next;
            count ++;
            ptr1 = ptr1.next;
        }
        prevNode.next = null;
        System.out.println("Number of nodes in loop are :::: " + count);
        
    }
    
    public void printList(Node head) {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.key + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        DetectLoopUsingFloydCycle llist = new DetectLoopUsingFloydCycle();
        llist.push(12);
        llist.push(45);
        llist.push(24);
        llist.push(47);
        llist.push(97);
        System.out.println("Printing the list before introducing loop into Linkedlist :: ");
        llist.printList(llist.head);
        llist.head.next.next.next.next.next = llist.head;
        System.out.println("Printing the list :: ");
        // llist.printList(llist.head);
        if (llist.detectAndRemoveLoop(llist.head)) {
            System.out.println("Loop Exists in LinkedList and has been removed");
            System.out.println("Printing the list after loop has been removed");
            llist.printList(llist.head);
        }
        else {
            System.out.print("Loop doesn't exists in the LinkedList");
        }
        
        
    }
    
}

  class Node {
        int key;
        Node next;
        Node(int k) {
        key = k;
        next = null;
            
        }
        
    }

