/*
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.
*/

public class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0, sum = 1;
        List<Integer> numbers = new ArrayList<Integer>();
        int[] factorial = new int[n + 1];
        StringBuilder sb = new StringBuilder();
        
        factorial[0] = 1;
        for (int i = 1; i <= n; i++){
            sum *= i;
            factorial[i] = sum;
        }
        
        for (int j = 1; j <= n; j++){
            numbers.add(j);
        }
        
        k--;
        
        for (int m = 1; m <= n; m++){
            int index = k / factorial[n - m];
            sb.append(String.valueOf(numbers.get(index)));
            numbers.remove(index);
            k -= index * factorial[n - m];
        }
        
        return sb.toString();
    }
}

/*
Reference:
https://discuss.leetcode.com/topic/17348/explain-like-i-m-five-java-solution-in-o-n/2
*/