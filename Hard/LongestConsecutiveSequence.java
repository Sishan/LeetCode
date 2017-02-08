/*
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
*/

public class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums){
            if (!map.containsKey(n)){
                int left = (map.containsKey(n-1)) ? map.get(n-1) : 0;
                int right = (map.containsKey(n+1)) ? map.get(n+1) : 0;
                 
                int sum = left + right + 1;
                res = Math.max(res,sum);
                
                map.put(n - left, sum);
                map.put(n + right, sum);
            }
            else {
                continue;
            }
        }
        return res;
    }
}


/*We will use HashMap. The key thing is to keep track of the sequence length and store that in the boundary points of the sequence. For example, as a result, for sequence {1, 2, 3, 4, 5}, map.get(1) and map.get(5) should both return 5.

Whenever a new element n is inserted into the map, do two things:

See if n - 1 and n + 1 exist in the map, and if so, it means there is an existing sequence next to n. Variables left and right will be the length of those two sequences, while 0 means there is no sequence and n will be the boundary point later. Store (left + right + 1) as the associated value to key n into the map.
Use left and right to locate the other end of the sequences to the left and right of n respectively, and replace the value with the new length.
*/

