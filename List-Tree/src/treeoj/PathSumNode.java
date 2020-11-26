package treeoj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSumNode {

    private static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    // 双重递归 思路：首先先序递归遍历每个节点，再以每个节点作为起始点递归寻找满足条件的路径。

    int pathnumber;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Sum(root, sum);
        pathSum(root.left, sum);
        pathSum(root.right, sum);
        return pathnumber;
    }


    public void Sum(TreeNode root, int sum) {
        if (root == null) return;
        sum -= root.val;
        if (sum == 0) {
            pathnumber++;
        }
        Sum(root.left, sum);
        Sum(root.right, sum);
    }
}
