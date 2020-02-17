package leetcode._1_easy._0226_invert_binary_tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() {
        solution = new Solution();
    }

    @Test
    public void test() {
        TreeNode n21 = new TreeNode(1);
        TreeNode n22 = new TreeNode(3);
        TreeNode n11 = new TreeNode(2);
        n11.left = n21;
        n11.right = n22;

        TreeNode n23 = new TreeNode(6);
        TreeNode n24 = new TreeNode(9);
        TreeNode n12 = new TreeNode(7);
        n12.left = n23;
        n12.right = n24;

        TreeNode n0 = new TreeNode(4);
        n0.left = n11;
        n0.right = n12;

        System.out.println(n0);
        TreeNode result = solution.invertTree(n0);
        System.out.println(result.toString());
        assertEquals("{4, left={7, left={9}, right={6}}, right={2, left={3}, right={1}}}", result.toString());
    }
}
