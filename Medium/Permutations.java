/*
Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        backTrack(res, new ArrayList<>(), nums);
        return res;
    }

    public void backTrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp)); // need to creat new ArrayList() object here
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tmp.contains(nums[i])) {
                    continue;
                }
                tmp.add(nums[i]);
                backTrack(res, tmp, nums);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}