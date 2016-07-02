public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int z = x;
        long y = 0;
        while (z != 0){
        	y = 10*y + z%10;
        	z = z/10
        }
        return x == y;
    }
}