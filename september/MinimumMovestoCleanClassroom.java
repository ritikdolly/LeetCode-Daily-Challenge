// Date: 01-09-2026
// 3568. Minimum Moves to Clean the Classroom
// https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/description/?envType=daily-question&envId=2026-09-01

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class MinimumMovestoCleanClassroom {
    class Solution {

        public int minMoves(String[] classroom, int energy) {

            int m = classroom.length;
            int n = classroom[0].length();

            int startR = 0;
            int startC = 0;

            // Assign a bit to every litter cell.
            int[][] litterId = new int[m][n];

            for (int[] row : litterId) {
                Arrays.fill(row, -1);
            }

            int litterCount = 0;

            // Find start and litter positions.
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {

                    char ch = classroom[r].charAt(c);

                    if (ch == 'S') {
                        startR = r;
                        startC = c;
                    } else if (ch == 'L') {
                        litterId[r][c] = litterCount++;
                    }
                }
            }

            // Nothing to clean.
            if (litterCount == 0) {
                return 0;
            }

            int totalMasks = 1 << litterCount;
            int fullMask = totalMasks - 1;

            /*
             * State:
             * row, col, remainingEnergy, mask
             */

            boolean[][][][] visited = new boolean[m][n][energy + 1][totalMasks];

            Queue<int[]> queue = new ArrayDeque<>();

            queue.offer(new int[] {
                    startR,
                    startC,
                    energy,
                    fullMask
            });

            visited[startR][startC][energy][fullMask] = true;

            int moves = 0;

            int[] dr = { -1, 1, 0, 0 };
            int[] dc = { 0, 0, -1, 1 };

            while (!queue.isEmpty()) {

                int size = queue.size();

                // Process one BFS level.
                while (size-- > 0) {

                    int[] state = queue.poll();

                    int r = state[0];
                    int c = state[1];
                    int currentEnergy = state[2];
                    int mask = state[3];

                    // All litter has been collected.
                    if (mask == 0) {
                        return moves;
                    }

                    // No energy -> cannot move.
                    if (currentEnergy == 0) {
                        continue;
                    }

                    for (int d = 0; d < 4; d++) {

                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        // Outside the grid.
                        if (nr < 0 || nr >= m ||
                                nc < 0 || nc >= n) {
                            continue;
                        }

                        char cell = classroom[nr].charAt(nc);

                        // Wall.
                        if (cell == 'X') {
                            continue;
                        }

                        // Every move costs 1 energy.
                        int nextEnergy = currentEnergy - 1;

                        // Recharge/reset cell.
                        if (cell == 'R') {
                            nextEnergy = energy;
                        }

                        // Collect litter.
                        int nextMask = mask;

                        if (cell == 'L') {
                            int bit = litterId[nr][nc];
                            nextMask &= ~(1 << bit);
                        }

                        // Avoid visiting the same state again.
                        if (!visited[nr][nc][nextEnergy][nextMask]) {

                            visited[nr][nc][nextEnergy][nextMask] = true;

                            queue.offer(new int[] {
                                    nr,
                                    nc,
                                    nextEnergy,
                                    nextMask
                            });
                        }
                    }
                }

                moves++;
            }

            // Impossible to collect all litter.
            return -1;
        }
    }

    public static void main(String[] args) {
        MinimumMovestoCleanClassroom obj = new MinimumMovestoCleanClassroom();
        Solution solution = obj.new Solution();

        String[] classroom = { "S.L", "XRX", "L.L" };
        int energy = 3;

        int result = solution.minMoves(classroom, energy);
        System.out.println("Minimum moves to clean the classroom: " + result);
    }
}
