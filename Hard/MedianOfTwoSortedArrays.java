/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1 < len2) return findMedianSortedArrays(nums2, nums1);
        if (len2 == 0) return ((double)(nums1[(len1 - 1)/2]) + (double)(nums1[len1/2]))/2.0;
        int lo = 0, hi = len2 * 2;
        while(lo <= hi){
            int mid2 = (lo + hi)/2;
            int mid1 = len2 + len1 - mid2;
            
            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[(mid1 - 1)/2];
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[(mid2 - 1)/2];
            double R1 = (mid1 == 2 * len1) ? Integer.MAX_VALUE : nums1[mid1/2];
            double R2 = (mid2 == 2 * len2) ? Integer.MAX_VALUE : nums2[mid2/2];
            
            if (L1 > R2) lo = mid2 + 1;                          //If we have L1 > R1, it means there are too many large numbers on the left half of A1, then we must move C1 to the left (i.e. move C2 to the right); 
            else if (L2 > R1) hi = mid2 - 1;                     //If L2 > R1, then there are too many large numbers on the left half of A2, and we must move C2 to the left.
            else return (Math.max(L1,L2) + Math.min(R1,R2))/2.0; //After we find the cut, the medium can be computed as (max(L1, L2) + min(R1, R2)) / 2;
        }
        return -1;
    }
}

/*
Two side notes:

A. since C1 and C2 can be mutually determined from each other, we might as well select 
the shorter array (say A2) and only move C2 around, and calculate C1 accordingly. That 
way we can achieve a run-time complexity of O(log(min(N1, N2)))

B. The only edge case is when a cut falls on the 0th(first) or the 2Nth(last) position. 
For instance, if C2 = 2N2, then R2 = A2[2*N2/2] = A2[N2], which exceeds the boundary of 
the array. To solve this problem, we can imagine that both A1 and A2 actually have two 
extra elements, INT_MAX at A[-1] and INT_MAX at A[N]. These additions don't change the 
result, but make the implementation easier: If any L falls out of the left boundary of 
the array, then L = INT_MIN, and if any R falls out of the right boundary, then
 R = INT_MAX.

 Reference:
 https://leetcode.com/problems/median-of-two-sorted-arrays/?tab=Solutions