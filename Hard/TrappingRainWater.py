class Solution:
    def trap(self, height: List[int]) -> int:
        if len(height) == 0:
            return 0
        
        left = 0
        right = len(height) - 1
        
        leftMax = height[left]
        rightMax = height[right]
        
        ans = 0
        
        while left < right:
            if height[left] < height[right]:
                if height[left] < leftMax:
                    ans += leftMax - height[left]
                else:
                    leftMax = height[left]
                left += 1
                
            else:
                if height[right] < rightMax:
                    ans += rightMax - height[right]
                else:
                    rightMax = height[right]
                right -= 1
                
        return ans