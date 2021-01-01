package com.vidya.fb;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 934. Shortest Bridge
 * <p>
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected group of 1s not connected to any other 1s.)
 * <p>
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * <p>
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at least 1.)
 * <p>
 * Example 1:
 * <p>
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * <p>
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= A.length == A[0].length <= 100
 * A[i][j] == 0 or A[i][j] == 1
 */
public class ShortestBridge {

    public static void main(String[] args) {
        int[][] nums = {{0,1},{1,0}};

        System.out.println(shortestBridge(nums));
    }

    static int shortestBridge(int[][] a) {
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] == 1 && !found) {
                    found = true;
                    dfs(a,i,j);
                }
                if (found && a[i][j] == 1) q.add(new int[]{i,j});
            }
        }
        int ans = 0;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int c = 0; c < size; c++) {
                int b[] = q.remove();
                int i = b[0];
                int j = b[1];
                if ((i > 0 && a[i-1][j] == 2) || (i < a.length-1 && a[i+1][j] == 2) || (j > 0 && a[i][j-1] == 2) ||
                        (j < a[0].length-1 && a[i][j+1] == 2)) return ans;
                if (i > 0 && a[i-1][j] == 0) {
                    a[i-1][j] = 1;
                    q.add(new int[]{i-1,j});
                }
                if (i < a.length-1 && a[i+1][j] == 0) {
                    a[i+1][j] = 1;
                    q.add(new int[]{i+1,j});
                }
                if (j > 0 && a[i][j-1] == 0) {
                    a[i][j-1] = 1;
                    q.add(new int[]{i,j-1});
                }
                if (j < a[0].length-1 && a[i][j+1] == 0) {
                    a[i][j+1] = 1;
                    q.add(new int[]{i,j+1});
                }
            }
            ans++;
        }
        return 0;
    }

    static void dfs(int[][] a, int i, int j) {

        if (i < 0 || i >= a.length || j < 0 ||  j >= a[0].length || a[i][j] == 0 || a[i][j] == 2) return;
        a[i][j] = 2;
        dfs(a,i-1,j);dfs(a,i+1,j);dfs(a,i,j-1);dfs(a,i,j+1);
    }

}
