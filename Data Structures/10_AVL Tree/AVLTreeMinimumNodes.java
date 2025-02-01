public class AVLTreeMinimumNodes {

    public static int AVLnodes(int height) {
        if (height == 0) {
            return 1;
        }
        if (height == 1) {
            return 2;
        }
        return 1 + AVLnodes(height - 1) + AVLnodes(height - 2);
    }

    public static void main(String[] args) {
        int H = 3;
        System.out.println(AVLnodes(H)); // Output: 4
    }
}
