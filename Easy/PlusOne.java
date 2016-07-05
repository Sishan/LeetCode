/*
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.
*/
public class Solution {
    public int[] plusOne(int[] digits) {
        if (digits.length == 0 || digits == null) return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i --){
        	int lastDigit = (digits[i] + carry)%10;
        	carry = (digits[i] + carry)/10;
        	digits[i] = lastDigit;
        	if (carry == 0) return digits;
        }
    	int[] res = new int[digits.length + 1];
    	res[0] = 1;
    	return res;
    }
}

/*
Notice:
If it is [9,9], output should be [1,0,0]. Should check the carry.
Check: (print out array)
System.out.print(Arrays.toString(plusOne(digits)));
*/