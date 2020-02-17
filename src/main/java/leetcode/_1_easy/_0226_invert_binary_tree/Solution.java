package leetcode._1_easy._0226_invert_binary_tree;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null && // 如果是非平衡树, 分支进入时候为空
                !(root.left == null && root.right == null)) { // 为叶节点时候跳过
            // 替换
            TreeNode tmp = root.left;

            root.left = root.right;
            root.right = tmp;
            // 递归替换
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
