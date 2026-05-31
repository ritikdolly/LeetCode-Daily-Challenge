// Date : 31-05-2026
// 2126. Destroying Asteroids
// https://leetcode.com/problems/destroying-asteroids/description/?envType=daily-question&envId=2026-05-31

import java.util.Arrays;

class DestroyingAsteroids {
    // Approach 1: Sort the asteroids and keep adding them to the mass. If at any point, the mass is less than the current asteroid, return false.
    // class Solution {
    //     public boolean asteroidsDestroyed(int mass, int[] asteroids) {
    //         int n = asteroids.length;
    //         Arrays.sort(asteroids);
    //         long m = mass;
    //         for (int num : asteroids) {
    //             if (num > m) {
    //                 return false;
    //             }
    //             m += num;
    //         }
    //         return true;
    //     }
    // }

    // Approach 2: Count the frequency of each asteroid and keep adding them to the mass. If at any point, the mass is less than the current asteroid, return false.
    class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            long[] arr = new long[100001];

            for (int num : asteroids) {
                arr[num]++;
            }

            long m = mass;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > 0) {
                    if (m < i) {
                        return false;
                    }
                    m += (i * arr[i]);
                }
            }
            return true;
        }
    }
    public static void main(String[] args) {
        Solution sol = new DestroyingAsteroids().new Solution();
        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};
        System.out.println(sol.asteroidsDestroyed(mass, asteroids)); // Output: false
    }
}