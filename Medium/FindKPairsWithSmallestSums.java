/*
You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

Define a pair (u,v) which consists of one element from the first array and one element from the second array.

Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:
Given nums1 = [1,7,11], nums2 = [2,4,6],  k = 3

Return: [1,2],[1,4],[1,6]

The first 3 pairs are returned from the sequence:
[1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
Example 2:
Given nums1 = [1,1,2], nums2 = [1,2,3],  k = 2

Return: [1,1],[1,1]

The first 2 pairs are returned from the sequence:
[1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
Example 3:
Given nums1 = [1,2], nums2 = [3],  k = 3 

Return: [1,3],[2,3]

All possible pairs are returned from the sequence:
[1,3],[2,3]
*/

class Solution {
    class Pair {
        int x;
        int y;
        int sum;

        public Pair(int _x, int _y, int _sum) {
            x = _x;
            y = _y;
            sum = _sum;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>((a, b) -> a.sum - b.sum);
        List<int[]> res = new ArrayList<int[]>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) {
            return res;
        }
        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new Pair(i, 0, nums1[i] + nums2[0]));
        }
        for (int j = 0; j < k; j++) {
            if (!queue.isEmpty()) {
                Pair cur = queue.poll();
                res.add(new int[] { nums1[cur.x], nums2[cur.y] });
                if (cur.y == nums2.length - 1) {
                    continue;
                }
                queue.offer(new Pair(cur.x, cur.y + 1, nums1[cur.x] + nums2[cur.y + 1]));
            } else {
                break;
            }
        }
        return res;
    }
}