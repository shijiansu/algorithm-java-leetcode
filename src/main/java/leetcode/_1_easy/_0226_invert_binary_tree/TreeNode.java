package leetcode._1_easy._0226_invert_binary_tree;

/**
 * Definition for a binary tree node
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "{" + val +
                (left == null ? "" : ", left=" + left) +
                (right == null ? "" : ", right=" + right) +
                '}';
    }
}
