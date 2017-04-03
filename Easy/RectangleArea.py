"""
Find the total area covered by two rectilinear rectangles in a 2D plane.
Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
Assume that the total area is never beyond the maximum possible value of int.
"""

class Solution(object):
    def computeArea(self, A, B, C, D, E, F, G, H):
        """
        :type A: int
        :type B: int
        :type C: int
        :type D: int
        :type E: int
        :type F: int
        :type G: int
        :type H: int
        :rtype: int
        """
        areaOfSqrA = (C - A) * (D - B)
        areaOfSqrB = (G - E) * (H - F)

        left = max(A,E)
        right = min(C,G)
        top = min(D,H)
        bottom = max(B,F)

        if (right > left and top > bottom):
            return areaOfSqrA + areaOfSqrB - (right - left) * (top - bottom)
        else:
            return areaOfSqrA + areaOfSqrB
