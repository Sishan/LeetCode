/*
Given a sorted integer array where the range of elements are in the inclusive range [lower, upper], return its missing ranges.

For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        long pre = (long) lower - 1;    // Corner case 1: overflow
        long post;

        if (nums.length == 0) {         // Corner case 2: nums is empty
            if (upper > lower) {
                res.add(String.valueOf(lower) + "->" + String.valueOf(upper));
            } else {
                res.add(String.valueOf(lower));
            }
            return res;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (i < nums.length) {
                post = nums[i];
            } else {
                post = (long) upper + 1;    // prevent overflow
            }
            if (post - pre == 2) {
                res.add(String.valueOf(pre + 1));
            } else if (post - pre > 2) {
                res.add(String.valueOf(pre + 1) + "->" + String.valueOf(post - 1));
            }

            pre = post;
        }
        return res;
    }
}
