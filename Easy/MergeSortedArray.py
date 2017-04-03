"""
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
"""

class Solution(object):
    def merge(self, nums1, m, nums2, n):
        """
        :type nums1: List[int]
        :type m: int
        :type nums2: List[int]
        :type n: int
        :rtype: void Do not return anything, modify nums1 in-place instead.
        """
        insertIndex = m + n - 1
        index1 = m - 1
        index2 = n - 1
        while (index2 >= 0):
            if (index1 < 0):
                nums1[insertIndex] = nums2[index2]
                insertIndex -= 1 
                index2 -= 1 
            elif (nums1[index1] >= nums2[index2]):
                nums1[insertIndex] = nums1[index1]
                insertIndex -= 1
                index1 -= 1
            else:
                nums1[insertIndex] = nums2[index2]
                insertIndex -= 1
                index2 -= 1
               
