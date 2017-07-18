/*
Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backTrack(res, new ArrayList(), candidates, target, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0) {
            res.add(new ArrayList<>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tmp.add(candidates[i]);
                backTrack(res, tmp, candidates, remain - candidates[i], i); // still start from i, allow duplicates 
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
*/