class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {

    Node root;

    public Node findMin(Node root) {
        if (root == null) {
            return null;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.root = new Node(50);
        tree.root.left = new Node(30);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(20);
        tree.root.left.right = new Node(40);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(80);
        
        Node minNode = tree.findMin(tree.root);
        if (minNode != null) {
            System.out.println("Minimum value in the BST: " + minNode.data);
        } else {
            System.out.println("Tree is empty.");
        }
    }
}
