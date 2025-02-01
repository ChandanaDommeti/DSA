class Node {
    int data;
    Node left, right;
    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    
    Node root;
    
    public boolean isBST(Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        
        if ((min != null && node.data <= min) || (max != null && node.data >= max)) {
            return false;
        }
        
        return isBST(node.left, min, node.data) && isBST(node.right, node.data, max);
    }
    
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        
        tree.root = new Node(10);
        tree.root.left = new Node(5);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(8);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(25);
        
        if (tree.isBST(tree.root, null, null)) {
            System.out.println("Is BST");
        } else {
            System.out.println("Not a BST");
        }
    }
}
