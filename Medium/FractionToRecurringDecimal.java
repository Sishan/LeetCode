/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

Given numerator = 1, denominator = 2, return "0.5".
Given numerator = 2, denominator = 1, return "2".
Given numerator = 2, denominator = 3, return "0.(6)".
*/

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder res = new StringBuilder();

        if ((numerator > 0) ^ (denominator > 0)) {      // numerator * denominator cannot handle overflow, -1 * - 2,147,483,647
            res.append('-');
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // Integer part
        res.append(num / den);
        num = num % den;
        if (num == 0) {
            return res.toString();
        }

        // Decimal part
        res.append(".");
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();
        map.put(num, res.length());

        while (num != 0) {
            num = num * 10;
            res.append(num / den);
            num = num % den;
            if (map.containsKey(num)) {
                res.insert(map.get(num), "(");
                res.append(")");
                return res.toString();
            } else {
                map.put(num, res.length());
            }
        }
        return res.toString();
    }
}