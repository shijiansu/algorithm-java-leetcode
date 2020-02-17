package leetcode._2_medium._0228_summary_ranges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();

        // 0个元素
        if (nums == null || nums.length < 1) {
            return result;
        }
        // 1个元素
        if (nums.length == 1) {
            result.add(nums[0] + "");
            return result;
        }

        for (int i = 0; i < nums.length; i++) { // 作为指针
            int start = i; // start也从新的后一个位置重新开始
            // 判断是否越界, 越界也可以进入, 说明到达最后元素了; 当前+1是与下一位元素相等, 继续
            while ((i < nums.length - 1) && (nums[i] + 1 == nums[i + 1])) {
                i++;
            }
            // 进入
            if (i == start) { // 只有一个元素就要进入的情况
                result.add(nums[start] + "");
            } else { // 多个元素进入, 默认了是i>start的情况
                result.add(nums[start] + "->" + nums[i]);
            }
        }
        return result;
    }
}
