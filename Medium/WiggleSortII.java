/*
Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space?
*/

public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int len = nums.length;
        int median = findMedian(0, len - 1, len / 2, nums);
        int left = 0, right = len - 1, i = 0;
        // map current index firstly
        while (i <= right) {
            int mappedCurIndex = newIndex(i, len);
            if (nums[mappedCurIndex] > median) {
                int mappedLeftIndex = newIndex(left, len);
                swap(mappedLeftIndex, mappedCurIndex, nums);
                left++;
                i++;
            } else if (nums[mappedCurIndex] < median) {
                int mappedRightIndex = newIndex(right, len);
                swap(mappedCurIndex, mappedRightIndex, nums);
                right--;
            } else {
                i++;
            }
        }
    }

    // {0,1,2,3,4,5} -> {1,3,5,0,2,4}
    // find mapped new inde
    /*
    Original Index => Mapped Index
    0 => (1 + 2 x 0) % 6 = 1 % 6 = 1
    1 => (1 + 2 x 1) % 6 = 3 % 6 = 3
    2 => (1 + 2 x 2) % 6 = 5 % 6 = 5

    These are what's less than median, if we continue this with indexes 3, 4, 5 we will cycle again:
    3 => (1 + 2 x 3) % 6 = 7 % 6 = 1
    4 => (1 + 2 x 4) % 6 = 9 % 6 = 3
    5 => (1 + 2 x 5) % 6 = 11 % 6 = 5

    and we don't want that, so for indexes larger than n/2 we want them to be even, (n|1) does that exactly. What n|1 does it that it gets the next odd number to n if it was even
    if n = 6 for example 110 | 1 = 111 = 7
    if n = 7 for example 111 | 1 = 111 = 7

    and this is what we want, instead of cycling the odd numbers again we want them to be even, and odd % odd number is even so updating the formula to :
    (1 + 2*index) % (n | 1)

    Then we have:
    3 => (1 + 2 x 3) % 7 = 7 % 7 = 0
    4 => (1 + 2 x 4) % 7 = 9 % 7 = 2
    5 => (1 + 2 x 5) % 7 = 11 % 7 = 4
    */
    public int newIndex(int index, int len) {
        return (1 + 2 * index) % (len | 1);
    }

    // use quicksort, average O(n) time
    public int findMedian(int start, int end, int k, int[] nums) {
        if (start > end)
            return Integer.MAX_VALUE;
        int pivot = nums[end];
        int indexOfWall = start;
        for (int i = start; i < end; i++) {
            if (nums[i] <= pivot) {
                swap(i, indexOfWall, nums);
                indexOfWall++;
            }
        }
        swap(indexOfWall, end, nums);
        if (indexOfWall == k) {
            return nums[indexOfWall];
        } else if (indexOfWall < k) {
            return findMedian(indexOfWall + 1, end, k, nums);
        } else {
            return findMedian(start, indexOfWall - 1, k, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}