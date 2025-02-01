import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeInsertion {
    
    static void insertLevelOrder(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            
            if (current.left == null) {
                current.left = new TreeNode(key);
                return;
            } else {
                queue.add(current.left);
            }
            
            if (current.right == null) {
                current.right = new TreeNode(key);
                return;
            } else {
                queue.add(current.right);
            }
        }
    }
    
    static void levelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            System.out.print(current.val + " ");
            
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        
        System.out.print("Original Tree (Level Order): ");
        levelOrder(root);
        System.out.println();
        
        insertLevelOrder(root, 7);
        
        System.out.print("Tree After Insertion (Level Order): ");
        levelOrder(root);
    }
}
