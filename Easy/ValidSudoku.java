/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
*/

public class Solution {
	public boolean isValidSudoku(char[][] board) {
		if (board.length < 9 || board[0].length < 9 || board == null)
			return false;
		boolean[] rowLine = new boolean[9];
		boolean[] colLine = new boolean[9];
		boolean[] subMatriLine = new boolean[9];

		for (int i = 0; i < 9; i++) {
			Arrays.fill(rowLine, false);
			Arrays.fill(colLine, false);
			for (int j = 0; j < 9; j++) {
				if (!isValid(rowLine, board[i][j]))
					return false;
				if (!isValid(colLine, board[j][i]))
					return false;
			}
		}

		for (int i = 0; i < 9; i += 3) {
			for (int j = 0; j < 9; j += 3) {
				Arrays.fill(subMatriLine, false);
				for (int k = 0; k < 9; k++) {
					if (!isValid(subMatriLine, board[i + k / 3][j + k % 3]))
						return false; //sub matrix index
				}
			}
		}
		return true;
	}

	public boolean isValid(boolean[] line, char digit) { // helper function to check if each input elemet is valid
		if (digit == '.')
			return true;
		int num = digit - '0';
		if (num < 1 || num > 9 || line[num - 1])
			return false;
		line[num - 1] = true;
		return true;
	}
}

/*
Similar to Sudoku Solver - https://oj.leetcode.com/problems/sudoku-solver/

We can use a helper function "check" which can check any sub rectangle of the board valid or not 

Remember to check for duplicate element in row, column and sub matrix

board[i + k/3][ j + k%3] is sub matrix index(前面的i每3个才变一次，后面的j每三个都循环一次)
[00,01,02]
[10,11,12]
[20,21,22]

这道题是Sudoku Solver的一个子问题，在解数独的时候我们需要验证当前数盘是否合法。其实思路比较简单，也就是用brute force。
对于每一行，每一列，每个九宫格进行验证，总共需要27次验证，每次看九个元素。所以时间复杂度就是O(3*n^2), n=9

Reference:
http://www.ninechapter.com/solutions/valid-sudoku/
http://www.cnblogs.com/yuzhangcmu/p/4067608.html
https://yusun2015.wordpress.com/2015/01/12/valid-sudoku/
http://blog.csdn.net/linhuanmars/article/details/20748171
*/