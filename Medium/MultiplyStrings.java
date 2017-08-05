/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

public class Solution {
    public String multiply(String num1, String num2) {
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        StringBuilder result = new StringBuilder();

        int[] d = new int[num1.length() + num2.length()];
        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                d[i + j] += a * b; // to get i-th digit of the result, sum all num1(j)*num(i-j) together 
            }
        }

        for (int k = 0; k < d.length; k++) {
            int digit = d[k] % 10;
            int carry = d[k] / 10;
            result.insert(0, digit);
            if (k < d.length - 1) {
                d[k + 1] += carry;
            }
        }

        while (result.length() > 0 && result.charAt(0) == '0') { // trim starting zeros
            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}

/*
这道题属于数值操作的题目，其实更多地是考察乘法运算的本质。基本思路是和加法运算还是近似的，只是进位和结果长度复杂一些。
我们仍然是从低位到高位对每一位进行计算，假设第一个数长度是n，第二个数长度是m，我们知道结果长度为m+n或者m+n-1（没有进位的情况）。
对于某一位i，要计算这个位上的数字，我们需要对所有能组合出这一位结果的位进行乘法，即第1位和第i位，第2位和第i-1位，... ，
然后累加起来，最后我们取个位上的数值，然后剩下的作为进位放到下一轮循环中。这个算法两层循环，每层循环次数是O(m+n)，所以时间复杂度是O((m+n)^2)。
算法中不需要额外空间，只需要维护一个进位变量即可，所以空间复杂度是O(1)。实现中有两个小细节，一个是循环中最后有一个if判断，
其实就是看最高一位是不是0（最高第二位不可能是0，除非两个源字符串最高位带有0），如果是就不需要加入字符串中了。另一个小问题是我们是由低位到高位放入结果串的，
所以最后要进行一次reverse，因为是一个O(m+n)的操作，不会影响算法复杂度。这道题其实还有更加优的做法，就是用Fast Fourier transform(FFT)。
使用FFT可以在O(nlogn)时间内求出多项式的乘法，在这里只需要把变量x带入10，然后按照求多项式的方法就可以求出两个大整数的成绩了。

Reference:
https://leetcodenotes.wordpress.com/2013/10/20/leetcode-multiply-strings-%E5%A4%A7%E6%95%B4%E6%95%B0%E7%9A%84%E5%AD%97%E7%AC%A6%E4%B8%B2%E4%B9%98%E6%B3%95/
http://blog.csdn.net/linhuanmars/article/details/20967763
https://yusun2015.wordpress.com/2015/01/16/multiply-strings/
*/