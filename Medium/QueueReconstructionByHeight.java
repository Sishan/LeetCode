/*
Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length == 0) {
            return people;
        }
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                // descending order for different hight; if same hight, ascending order
                // e.g. [[7,0],[7,1],[6,1],[5,0],[5,2],[4,4]]
                return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];  
            }
        });

        List<int[]> res = new ArrayList<int[]>();

        for (int[] cur : people) {
        // insert shorter item later
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}