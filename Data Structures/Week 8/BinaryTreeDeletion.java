class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeDeletion {

    static void deleteNode(TreeNode root, int key) {
        if (root == null) return;

        TreeNode target = null, deepest = null, parent = null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            deepest = queue.poll();
            if (deepest.left != null) {
                queue.add(deepest.left);
                parent = deepest;
            }
            if (deepest.right != null) {
                queue.add(deepest.right);
                parent = deepest;
            }

            if (deepest.val == key) {
                target = deepest;
            }
        }

        if (target != null) {
            target.val = deepest.val;
            if (parent != null) {
                if (parent.left != null && parent.left.val == deepest.val) {
                    parent.left = null;
                } else if (parent.right != null && parent.right.val == deepest.val) {
                    parent.right = null;
                }
            }
        }
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.right = new TreeNode(40);

        System.out.print("Original Tree (Inorder): ");
        inorder(root);
        System.out.println();

        deleteNode(root, 20);

        System.out.print("Tree After Deletion (Inorder): ");
        inorder(root);
    }
}
