/*
Implement pow(x, n).
*/

public class Solution {
    public double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n<0){
           if( n == Integer.MIN_VALUE) {
                n++;                           // Make -2147483648 to -2147483647 to avoid overflow
                if(x < 0)  x = -x;             // We made n odd so need to update sign
            }
            n = -n;
            x = 1/x;
        }
        return (n%2 == 0) ? myPow(x*x, n/2) : x*myPow(x*x, n/2);
    }
}