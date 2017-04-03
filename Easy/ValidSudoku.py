"""
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
"""

class Solution(object):
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        big = set()
        for i in xrange(9):
        	for j in xrange(9):
        	    if board[i][j] != '.':
        	        cur = board[i][j]
        	        if (i,cur) in big or (cur,j) in big or (i/3, j/3, cur) in big:
        		    	return False
        	        big.add((i,cur))
        	        big.add((cur,j))
        	        big.add((i/3, j/3, cur))
        return True