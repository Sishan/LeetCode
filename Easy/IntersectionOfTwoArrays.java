/*
Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:
Each element in the result must be unique.
The result can be in any order.
*/


// Time complexity: O(nlogn)
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

// Time complexity: O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> nums = new HashSet<Integer>();
        HashSet<Integer> intersection = new HashSet<Integer>();
        
        for (int i = 0; i < nums1.length; i++){
            nums.add(nums1[i]);
        }
        
        for (int j = 0; j < nums2.length; j++) {
            if (nums.contains(nums2[j])) {
                intersection.add(nums2[j]);
            }
        }
        
        int[] res = new int[intersection.size()];
        int idx = 0;
        for (Integer num : intersection) {
            res[idx++] = num;
        }
        
        return res;
    }
}

// Time complexity: O(nlogn)
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (Integer num : nums1) {
            if (binarySearch(nums2, num)) {
                set.add(num);
            }
        }
        int i = 0;
        int[] result = new int[set.size()];
        for (Integer num : set) {
            result[i++] = num;
        }
        return result;
    }
    
    public boolean binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}