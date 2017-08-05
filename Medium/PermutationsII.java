/*
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0)
            return res;
        Arrays.sort(nums);
        backTrack(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    public void backTrack(List<List<Integer>> res, ArrayList<Integer> tmp, int[] nums, boolean[] used) {
        if (tmp.size() == nums.length) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) { //when duplicates are selected, the order is ascending (index from small to large)
                    continue;
                }
                tmp.add(nums[i]);
                used[i] = true;
                backTrack(res, tmp, nums, used);
                tmp.remove(tmp.size() - 1);
                used[i] = false;
            }
        }
    }
}