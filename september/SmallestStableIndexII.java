// Date: 05-09-2026
// Problem Title: 3904. Smallest Stable Index II
//  problem link: https://leetcode.com/problems/smallest-stable-index-ii/description/?envType=daily-question&envId=2026-09-05
public class SmallestStableIndexII {

    // Approach: We can use a two-pointer approach to find the smallest stable index. 
    // We will maintain a sliding window of size k and keep track of the maximum and minimum values in that window. 
    // If the difference between the maximum and minimum values is less than or equal to k, we have found a stable index.
    class Solution {
        public int firstStableIndex(int[] nums, int k) {
            int n=nums.length;
            int []minArr=new int[n];
            minArr[n-1]=nums[n-1];

            for(int i=n-2;i>-1;i--){
                minArr[i]=Math.min(minArr[i+1],nums[i]);
            }
            int maxVal=0;
            for(int i=0;i<n;i++){
                maxVal=Math.max(nums[i],maxVal);
                if((maxVal-minArr[i])<=k){
                    return i;
                }
            }
            return -1;
        }
    }
    public static void main(String[] args) {
        SmallestStableIndexII obj = new SmallestStableIndexII();
        Solution solution = obj.new Solution();
        int[] nums = {1, 3, 6, 4, 1};
        int k = 2;
        int result = solution.firstStableIndex(nums, k);
        System.out.println("The smallest stable index is: " + result);
    }    
}