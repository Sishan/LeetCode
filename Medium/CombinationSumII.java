/*
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0)
            return res;
        Arrays.sort(candidates);
        backTrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> tmp, int[] candidates, int remain, int start) {
        if (remain < 0)
            return;
        else if (remain == 0) {
            res.add(new ArrayList<Integer>(tmp));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i - 1] == candidates[i])
                    continue; // skip duplicates
                tmp.add(candidates[i]);
                backTrack(res, tmp, candidates, remain - candidates[i], i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/46161/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning/2
*/