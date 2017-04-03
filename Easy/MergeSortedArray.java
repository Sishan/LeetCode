/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
*/

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = m + n - 1;
        int indexA = m - 1;
        int indexB = n - 1;
        while (indexB >= 0){
            if (indexA < 0) nums1[insertIndex--] = nums2[indexB--];
            else {
                if (nums1[indexA] >= nums2[indexB]) nums1[insertIndex--] = nums1[indexA--];
                else nums1[insertIndex--] = nums2[indexB--];
            }
        }
    }
}


/*
Similar to CC150 (11-1) merge two sorted array - (SortingAndSearching_1.java)
Similar to Median Of Two Sorted Arrays - https://leetcode.com/problems/median-of-two-sorted-arrays/

The key idea is instead starting merging from the front, starting from the end, as the end of A is empty. 
Starting from the end is because that the result is still stored in A, if starting from the front, some unchecked elements may be overlapped.
Time complexity is O(m+n), Space complexity is O(1). Similiar to Merge Two Sorted Lists.

Reference:
http://blog.csdn.net/linhuanmars/article/details/19712333
https://yusun2015.wordpress.com/2015/01/07/merge-sorted-array
*/
