package treeoj;

import java.util.*;

public class PathSumRoot {

    private static TreeNode root;

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    List<List<Integer>> list = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return list;
    }

    //从树的根节点开始往下一直到 叶节点 所经过的节点
    private void dfs(TreeNode root, int sum) {
        if (root == null) return;
        path.add(root.val);
        sum -= root.val;
        /**
         *记录路径时若直接执行 res.append(path) ，则是将 path对象加入了 res;
         *递归操作,后续 path改变时, res中的 path对象也会随之改变
         *
         *【正确做法】：res.append(list(path)) ,相当于复制了一个 path并加入到 res
         */
        if (sum == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        //向上回溯前，需要将当前节点从路径 path中删除，即执行path.pop()
        path.removeLast();
    }
}
