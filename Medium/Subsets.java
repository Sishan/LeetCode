/*
Given a set of distinct integers, nums, return all possible subsets.

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTrack(res, new ArrayList<>(), nums, 0);
        return res;
    }
    
    public void backTrack(List<List<Integer>> res, ArrayList<Integer> tmpList, int[] nums, int start){
        res.add(new ArrayList<Integer>(tmpList));
        for (int i = start; i < nums.length; i++){
            tmpList.add(nums[i]);
            backTrack(res, tmpList, nums, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}