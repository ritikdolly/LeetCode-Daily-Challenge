// Date: 17-02-2026
// 401. Binary Watch

// https://leetcode.com/problems/binary-watch/?envType=daily-question&envId=2026-02-17

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    class Solution {
        public List<String> readBinaryWatch(int turnedOn) {
            List<String> res = new ArrayList<>();

            for (int h = 0; h < 12; h++) {
                for (int m = 0; m < 60; m++) {
                    if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(h);
                        sb.append(":");
                        if (m < 10) {
                            sb.append("0" + m);
                        } else {
                            sb.append(m);
                        }
                        res.add(sb.toString());
                    }
                }
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Solution sol = new BinaryWatch().new Solution();
        int turnedOn = 2;
        System.out.println(sol.readBinaryWatch(turnedOn));
    }
}
