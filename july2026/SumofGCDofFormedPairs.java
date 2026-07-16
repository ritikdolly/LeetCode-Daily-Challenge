
// date: 16-07-2026
//problem: 3867. Sum of GCD of Formed Pairs
// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/description/?envType=daily-question&envId=2026-07-16
import java.util.Arrays;

public class SumofGCDofFormedPairs {

    // Approach 1: The approach is to find the maximum value and the GCD of the
    // prefix of the array. Then, we sort the prefix GCD array and use two pointers
    // to calculate the sum of GCDs of formed pairs.
    // class Solution {
    // public static int findGCD(int a, int b) {
    // if (b == 0) {
    // return a;
    // }
    // return findGCD(b, a % b);
    // }

    // public long gcdSum(int[] nums) {
    // int n = nums.length;

    // int[] max = new int[n];
    // int[] prefixGcd = new int[n];

    // max[0] = nums[0];
    // prefixGcd[0] = nums[0];
    // for (int i = 1; i < n; i++) {
    // max[i] = Math.max(max[i - 1], nums[i]);
    // prefixGcd[i] = findGCD(nums[i], max[i]);
    // }

    // Arrays.sort(prefixGcd);
    // long sum = 0;
    // int left = 0, right = n - 1;

    // while (left < right) {
    // sum += findGCD(prefixGcd[left], prefixGcd[right]);
    // left++;
    // right--;
    // }
    // return sum;
    // }
    // }

    // Approach 2: The approach is to find the maximum value and the GCD of the
    // prefix of the array. Then, we sort the prefix GCD array and use two pointers to calculate the sum of GCDs of formed pairs.
    class Solution {
        public static int findGCD(int a, int b) {
            while (b != 0) {
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

        public long gcdSum(int[] nums) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
                nums[i] = findGCD(max, nums[i]);
            }
            Arrays.sort(nums);
            long sum = 0;
            int l = 0, r = nums.length - 1;
            while (l < r) {
                sum += findGCD(nums[l++], nums[r--]);
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        SumofGCDofFormedPairs outer = new SumofGCDofFormedPairs();
        Solution solution = outer.new Solution();

        int[] nums = { 12, 15, 18, 21 };
        long result = solution.gcdSum(nums);
        System.out.println(result);
    }
}
