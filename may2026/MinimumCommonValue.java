// date: 19-05-2026
// 2540. Minimum Common Value
// https://leetcode.com/problems/minimum-common-value/?envType=daily-question&envId=2026-05-19
public class MinimumCommonValue {
    class Solution {
        public int getCommon(int[] nums1, int[] nums2) {

            int idx1 = 0, idx2 = 0;

            while (idx1 < nums1.length && idx2 < nums2.length) {

                if (nums1[idx1] == nums2[idx2]) {
                    return nums1[idx1];
                }

                else if (nums1[idx1] < nums2[idx2]) {
                    idx1++;
                }

                else {
                    idx2++;
                }
            }

            return -1;
        }
    }
    public static void main(String[] args) {
        MinimumCommonValue m = new MinimumCommonValue();
        Solution s = m.new Solution();

        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4 };

        System.out.println(s.getCommon(nums1, nums2));
    }
}
