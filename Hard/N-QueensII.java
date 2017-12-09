/*
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
*/

class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] dig = new boolean[2 * n];
        boolean[] antiDig = new boolean[2 * n];
        backTrack(0, cols, dig, antiDig, n);
        return count;
    }

    public void backTrack(int row, boolean[] cols, boolean[] dig, boolean[] antiDig, int n) {
        if (row == n) {
            count++;
        }

        for (int col = 0; col < n; col++) {
            int id1 = col + row; // dig
            int id2 = col + (n - row); //anti-dig

            if (cols[col] || dig[id1] || antiDig[id2]) {
                continue;
            }
            cols[col] = dig[id1] = antiDig[id2] = true;
            backTrack(row + 1, cols, dig, antiDig, n);
            cols[col] = dig[id1] = antiDig[id2] = false;
        }

    }
}