// Date: 15-06-2024
// 1622. Fancy Sequence
// https://leetcode.com/problems/fancy-sequence/description/?envType=daily-question&

import java.util.ArrayList;
import java.util.List;

public class FancySequence {
    class Fancy {
        List<Long> list;
        long add = 0;
        long mul = 1;
        int mod = 1000000007;

        public Fancy() {
            list = new ArrayList<>();
        }

        // val=(originalVal-add)/multiple
        public void append(int val) {
            long x = (val - add + mod) % mod;
            x = (x * power(mul, mod - 2)) % mod;
            list.add(x);
        }

        public void addAll(int inc) {
            add = (add + inc) % mod;
        }

        public void multAll(int m) {
            mul = (mul * m) % mod;
            add = (add * m) % mod;
        }

        public int getIndex(int idx) {
            if (list.size() <= idx) {
                return -1;
            }
            long val = list.get(idx);
            long res = (val * mul) % mod;
            res = (res + add) % mod;
            return (int) res;
        }

        private long power(long a, long b) {
            long res = 1;
            a %= mod;
            while (b > 0) {
                if ((b & 1) == 1)
                    res = (res * a) % mod;
                a = (a * a) % mod;
                b >>= 1;
            }
            return res;
        }
    }
    public static void main(String[] args) {
        Fancy fancy = new FancySequence().new Fancy();
        fancy.append(2);   // fancy sequence: [2]
        fancy.addAll(3);  // fancy sequence: [5]
        fancy.append(7);   // fancy sequence: [5, 7]
        fancy.multAll(2);  // fancy sequence: [10, 14]
        System.out.println(fancy.getIndex(0)); // return 10
        fancy.addAll(3);  // fancy sequence: [13, 17]
        fancy.append(10);  // fancy sequence: [13, 17, 10]
        fancy.multAll(2);  // fancy sequence: [26, 34, 20]
        System.out.println(fancy.getIndex(0)); // return 26
        System.out.println(fancy.getIndex(1)); // return 34
        System.out.println(fancy.getIndex(2)); // return 20
    }
}
