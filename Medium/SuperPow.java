/*

Your task is to calculate a^b mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.

Example1:

a = 2
b = [3]

Result: 8
Example2:

a = 2
b = [1,0]

Result: 1024
*/

class Solution {
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }
    
    public int superPow(int a, int[] b, int len, int k) {
        if (len == 1) {
            return powMod(a, b[0], k);
        }
        
        return powMod(superPow(a, b, len - 1, k), 10, k) * powMod(a, b[len - 1], k) % k;
    }
    
    public int powMod(int x, int y, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < y; i++) {
            pow = (pow * x) % k;
        }
        return pow;
    }
}

/*
One knowledge: ab % k = (a%k)(b%k)%k
Since the power here is an array, we'd better handle it digit by digit.
One observation:
a^1234567 % k = (a^1234560 % k) * (a^7 % k) % k = (a^123456 % k)^10 % k * (a^7 % k) % k
Looks complicated? Let me put it other way:
Suppose f(a, b) calculates a^b % k; Then translate above formula to using f :
f(a,1234567) = f(a, 1234560) * f(a, 7) % k = f(f(a, 123456),10) * f(a,7)%k;
*/