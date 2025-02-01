class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree2{

    Node root;

    public void findSecondLargest(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            System.out.println("No second largest element.");
            return;
        }

        Node current = root;
        Node previous = null;

        while (current != null) {
            if (current.right == null) {
                if (current.left != null) {
                    System.out.println("Second Largest: " + current.data);
                    return;
                }
                previous = current;
                current = current.left;
            } else {
                previous = current;
                current = current.right;
            }
        }
        System.out.println("Second Largest: " + previous.data);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);
        tree.root.right.right = new Node(30);

        tree.findSecondLargest(tree.root);

        BinarySearchTree tree2 = new BinarySearchTree();
        tree2.root = new Node(10);
        tree2.root.left = new Node(5);

        tree2.findSecondLargest(tree2.root);
    }
}
