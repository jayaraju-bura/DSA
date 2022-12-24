class Node {
    int data;
    Node left;
    Node right;
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class FloorCeil {
    private Node floor, ceil;
    FloorCeil() {
        this.floor = new Node(-1);
        this.ceil = new Node(-1);
    }
    public void setFloor(Node node) {
        this.floor = node;
        
    }
    public void setCeil(Node node) {
        this.ceil = node;
    }
    public int getCeil() {
        return this.ceil.data;
    }
    public int getFloor() {
        return this.floor.data;
    }
}

class FindFloorCeilOfNumber {
    public static void findFloorCeil(FloorCeil obj, Node node, int i) {
        if (node == null) {
            return;
        }
        else if (node.data == i) {
            obj.setFloor(node);
            obj.setCeil(node);
        }
        else if (node.data > i) {
            obj.setCeil(node);
            findFloorCeil(obj, node.left, i);
            
        }
        else if (node.data < i) {
            obj.setFloor(node);
            findFloorCeil(obj, node.right, i);
            
        }
        
    }
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        else if (key < root.data) {
            root.left = insert(root.left, key);
        }
        else if (key > root.data) {
            root.right = insert(root.right, key);
        }
        return root;
    }
    
    public static void main(String[] args) {
        
        int[] data = {2, 4, 6, 8, 9, 10, 12 };
        Node root = null;
        for (int key : data) {
            root = insert(root, key);
        }
        for (int i = 0 ; i < 15; i++) {
            FloorCeil obj = new FloorCeil();
            findFloorCeil(obj, root, i);
            System.out.println("Floor of the key " + i + " is  " + obj.getFloor() + ", \t  Ceil of the Key  " + i + " is  " + obj.getCeil());
            
        }
    }
}



// Sample output
// Floor of the key 0 is  -1, 	  Ceil of the Key  0 is  2
// Floor of the key 1 is  -1, 	  Ceil of the Key  1 is  2
// Floor of the key 2 is  2, 	    Ceil of the Key  2 is  2
// Floor of the key 3 is  2, 	    Ceil of the Key  3 is  4
// Floor of the key 4 is  4, 	    Ceil of the Key  4 is  4
// Floor of the key 5 is  4, 	    Ceil of the Key  5 is  6
// Floor of the key 6 is  6, 	    Ceil of the Key  6 is  6
// Floor of the key 7 is  6, 	    Ceil of the Key  7 is  8
// Floor of the key 8 is  8, 	    Ceil of the Key  8 is  8
// Floor of the key 9 is  9, 	    Ceil of the Key  9 is  9
// Floor of the key 10 is  10, 	  Ceil of the Key  10 is  10
// Floor of the key 11 is  10, 	  Ceil of the Key  11 is  12
// Floor of the key 12 is  12, 	  Ceil of the Key  12 is  12
// Floor of the key 13 is  12, 	  Ceil of the Key  13 is  -1
// Floor of the key 14 is  12, 	  Ceil of the Key  14 is  -1
