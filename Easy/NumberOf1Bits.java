/*
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
*/

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        for (int i = 0; i < 32; i ++){
        	res += (n & 1);
        	n = n >> 1;
        }
        return res;
    }
}

//version # 2 
public int hammingWeight(int n) {
    int sum = 0;
    while (n != 0) {
        sum++;
        n &= (n - 1);
    }
    return sum;
}

/*
The key idea of the second idea is taht in the binary representation, the least significant 11-bit in nn always corresponds to a 00-bit in n - 1n−1. 
Therefore, anding the two numbers nn and n - 1n−1 always flips the least significant 11-bit in nn to 00, and keeps all other bits the same.
*/
