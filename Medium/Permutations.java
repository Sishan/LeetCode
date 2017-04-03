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
        ArrayList<Integer> tempList = new ArrayList<Integer>();
        backTrack(res, tempList, nums);
        return res;
    }
    
    public void backTrack(List<List<Integer>> res, ArrayList<Integer> tempList, int[] nums){
        if (tempList.size() == nums.length) {
            res.add(new ArrayList<>(tempList));}        // need to creat new ArrayList<> object here
        else {
            for (int i = 0; i < nums.length; i++){
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backTrack(res, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}