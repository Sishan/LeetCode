/*
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
#include <vector>

using namespace std;

class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> subsets;
        vector<int> subset;
        backTrack(nums, subsets, subset, 0);
        return subsets;
    }
    
private:
    void backTrack(vector<int>& nums, vector<vector<int>>& subsets, vector<int>& subset, int begin) {
        subsets.push_back(subset);
        for (int i = begin; i < nums.size(); i++) {
            if (i != begin && nums[i] == nums[i - 1]) {
                continue;
            }
            subset.push_back(nums[i]);
            backTrack(nums, subsets, subset, i + 1);
            subset.pop_back();
        }
    }
};