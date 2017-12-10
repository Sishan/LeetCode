/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
*/

class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int idx2 = 0, idx3 = 0, idx5 = 0;
        int fact2 = 2, fact3 = 3, fact5 = 5;
        for (int i = 1; i < n; i++) {
            int min = Math.min(Math.min(fact2, fact3), fact5);
            ugly[i] = min;
            if (fact2 == min) {
                fact2 = 2 * ugly[++idx2];
            }
            if (fact3 == min) {
                fact3 = 3 * ugly[++idx3];
            }
            if (fact5 == min) {
                fact5 = 5 * ugly[++idx5];
            }
        }
        return ugly[n - 1];
    }
}