class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BSTDeletion {

    static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.val = minValue(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    static int minValue(TreeNode root) {
        int minValue = root.val;
        while (root.left != null) {
            minValue = root.left.val;
            root = root.left;
        }
        return minValue;
    }

    static boolean search(TreeNode root, int key) {
        if (root == null) return false;
        if (root.val == key) return true;
        if (key < root.val) return search(root.left, key);
        return search(root.right, key);
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(50);
        root.left = new TreeNode(30);
        root.right = new TreeNode(70);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(40);
        root.right.left = new TreeNode(60);
        root.right.right = new TreeNode(80);

        System.out.print("Original Tree (Inorder): ");
        inorder(root);
        System.out.println();

        System.out.println("Search 40 in the BST: " + search(root, 40));
        System.out.println("Search 100 in the BST: " + search(root, 100));

        root = deleteNode(root, 20);

        System.out.print("Tree After Deletion of 20 (Inorder): ");
        inorder(root);
        System.out.println();
    }
}
