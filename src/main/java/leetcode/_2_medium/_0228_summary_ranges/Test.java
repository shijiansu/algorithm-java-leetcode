package leetcode._2_medium._0228_summary_ranges;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};

        Solution solution = new Solution();
        List<String> result = solution.summaryRanges(nums);
        System.out.println(result);
    }
}
