package leetcode._3_hard._0065_valid_number;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Test {
    public long total = 0;

    public void printTotalTime() {
        System.out.println("Answer All : " + total + " ms");
    }

    private void test(Solution solution, int i, boolean b, String s, boolean r) {
        System.out.println("----------------------------------------");
        System.out.println("Answer " + i + " String: " + s);
        long startTime = System.currentTimeMillis();
        boolean number = solution.isNumber(s);

        long end = System.currentTimeMillis() - startTime;
        System.out.println("Answer " + i + " : " + end + " ms");
        total += end;

        System.out.println("Answer " + i + " : " + number);

        if (b && r != number) {
            throw new RuntimeException("Mismatched: " + s);
        }
    }

    public void testCase(Solution solution, boolean b) {
        Map<String, Boolean> ss = new HashMap<>();
        ss.put("0", true);
        ss.put(" 0.1 ", true);
        ss.put("abc", false);
        ss.put("1 a", false);
        ss.put("2e10", true);
        ss.put("-2e-10", true);
        ss.put("e-10", false);
        ss.put("-10", true);
        ss.put("+.8", true);
        ss.put("+.8e+10", true);

        int i = 0;
        for (Entry<String, Boolean> e : ss.entrySet()) {
            test(solution, i++, b, e.getKey(), e.getValue());
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Test ts = new Test();
        ts.testCase(solution, true);
        ts.printTotalTime();
    }
}
