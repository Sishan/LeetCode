/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        HashSet<Integer> map = new HashSet<Integer>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length){
            if (nums1[i] < nums2[j]) i++;
            else if (nums1[i] > nums2[j]) j++;
            else{
                map.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[map.size()];
        int k = 0;
        for (Integer nums : map){
            res[k++] = nums;
        }
        return res;
    }
}