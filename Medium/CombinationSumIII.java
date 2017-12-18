/*

Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.


Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]

Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]
*/

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTrack(res, k, n, 1, new ArrayList<Integer>());
        return res;
    }

    public void backTrack(List<List<Integer>> res, int k, int remaining, int start, List<Integer> comb) {
        if (comb.size() == k && remaining == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            backTrack(res, k, remaining - i, i + 1, comb);
            comb.remove(comb.size() - 1);
        }
    }
}