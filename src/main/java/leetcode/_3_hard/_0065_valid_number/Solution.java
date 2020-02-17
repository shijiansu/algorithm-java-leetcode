package leetcode._3_hard._0065_valid_number;

import java.util.regex.Pattern;

public class Solution {

    public boolean isNumber(String s) {
        // 去除前后空格
        if (s.contains(" ")) {
            s = s.trim();
        }
        // ([-+]?), 可选, 可能有-或者+;
        // ((\\d+)(\\.)?|(\\.)(\\d+)), 两种情况, 数字加上可能的., 或者.加上可能的数字;
        // (\\d*), 中间可能有数字, 这个是配合"数字.数字"的情况;
        // (e[-+]?(\\d+))?, 可选, e后面必须跟数字;
        Pattern r = Pattern.compile("^([-+]?)((\\d+)(\\.)?|(\\.)(\\d+))(\\d*)(e[-+]?(\\d+))?$");
        return r.matcher(s).find();
    }
}
