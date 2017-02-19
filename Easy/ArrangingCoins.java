/*
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:

n = 5

The coins can form the following rows:
¤
¤ ¤
¤ ¤

Because the 3rd row is incomplete, we return 2.
Example 2:

n = 8

The coins can form the following rows:
¤
¤ ¤
¤ ¤ ¤
¤ ¤

Because the 4th row is incomplete, we return 3.
*/

public class Solution {
    public int arrangeCoins(int n) {
        int left = 1, right = n;
        while (left <= right){
            int mid = (left + right) >>> 1;
            if ((0.5 * mid * mid + 0.5 * mid) <= n) left = mid + 1;
            else right = mid - 1;
        }
        return left - 1;
    }
}

/*
Time Complexity:

Best Case `O(log_b(n))` : With respect to the input, the algorithm will always depend on the value of input.
Average Case `O(log_b(n))` : With respect to the input, the algorithm will always depend on the value of input.
Worst Case `O(log_b(n))` : With respect to the input, the algorithm will always depend on the value of input.
Auxiliary Space:

Worst Case `O(1)` : Additional variables are of constant size.
*/

//Solution #2
public class Solution {
    public int arrangeCoins(int n) {   
        if(n == 0) return 0;
        int total = n;
        int i = 1;
        while(true) {
            if(total - i < 0) {
                return i-1;
            }
            total = total - i;
            i++;
        }
    }
}

//Solution #3
public class Solution {
    public int arrangeCoins(int n) {   
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
}

/*
`1 + 2 + 3 + 4 + 5 + 6 + 7 + ... + x <= n`
`sum_{i=1}^x i <= n`
Running sum can be simplified,

`(x * ( x + 1)) / 2 <= n`
Using quadratic formula, `x` is evaluated to be,

`x = 1 / 2 * (-sqrt(8 * n + 1)-1)` (Inapplicable) or `x = 1 / 2 * (sqrt(8 * n + 1)-1)`
*/