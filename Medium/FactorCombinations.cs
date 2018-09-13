/*
Numbers can be regarded as product of its factors. For example,
8 = 2 x 2 x 2;
  = 2 x 4.
Write a function that takes an integer n and return all possible combinations of its factors.
Note:
You may assume that n is always positive.
Factors should be greater than 1 and less than n.
Example 1: 
Input: 1
Output: []
Example 2: 
Input: 37
Output:[]
Example 3: 
Input: 12
Output:
[
  [2, 6],
  [2, 2, 3],
  [3, 4]
]
Example 4: 
Input: 32
Output:
[
  [2, 16],
  [2, 2, 8],
  [2, 2, 2, 4],
  [2, 2, 2, 2, 2],
  [2, 4, 4],
  [4, 8]
]
*/

public class Solution {
    public IList<IList<int>> GetFactors(int n) 
    {
        IList<IList<int>> res = new List<IList<int>>();

        helper(res, new List<int>(), n, 2);
        return res;
    }
    
    public void helper(IList<IList<int>> res, IList<int> item, int n, int start) 
    {
        if (n <= 1)
        {
            if (item.Count() > 1)
            {
                res.Add(new List<int> (item));
            }
            return;
        }
        for  (int i = start; i <= n; i++)
        {
            if (n % i == 0)
            {
                item.Add(i);
                helper(res, item, n / i, i);
                item.RemoveAt(item.Count() - 1);
            }
        }
    }
}