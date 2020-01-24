class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dict = { }
        
        for idx in range(len(nums)):
            if (target - nums[idx]) in dict:
                return [dict[target - nums[idx]], idx]
            else:
                dict[nums[idx]] = idx