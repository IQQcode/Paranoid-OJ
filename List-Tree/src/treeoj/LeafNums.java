package treeoj;

/**
 * @Author: iqqcode
 * @Date: 2020-10-29 16:32
 * @Description:求叶子节点数
 */
public class LeafNums {

    private static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static int getLeafCount(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            System.out.println("leaf nodes val: " + root.val);
            return 1;
        }
        return getLeafCount(root.left) + getLeafCount(root.right);
    }

    public static void main(String[] args) {
        LeafNums tree = new LeafNums();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(tree.getLeafCount(root));
    }
}
