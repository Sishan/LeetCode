/*
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (Integer num : nums) {
            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}


class Solution2 {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int p = QuickSelect(nums, 0, n - 1, n - k + 1);  // n - k + 1 since the quickselect method find kth smallest item
        return nums[p];
    }
    
    public int QuickSelect(int[] nums, int lo, int hi, int k){
        int i = lo, j = hi, pivot = nums[hi];  // set the rightest element to be the pivot
        while (i < j){
            if (nums[i++] > pivot){
                swap(nums, --i, --j);
            }
        }
        swap(nums, i, hi);
        
        int m = i - lo + 1;   // count number of items less or equal to the pivot from left 
        
        if (k == m) return i;
        
        // pivot is bigger than the target
        else if (k < m) return QuickSelect(nums, lo, i - 1, k);
        
        // pivot is smaller than the target
        else return QuickSelect(nums, i + 1, hi, k - m);
    }
    
    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
