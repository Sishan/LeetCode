/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
Note: Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int num = 0;
        char sign = '+';
        Stack<Integer> stk = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (Character.isDigit(cur)) {
                num = num * 10 + (int) (cur - '0');
            }
            if (!Character.isDigit(cur) && cur != ' ' || i == len - 1) {
                if (sign == '-') {
                    stk.push(-num);
                }
                if (sign == '+') {
                    stk.push(num);
                }
                if (sign == '*') {
                    stk.push(stk.pop() * num);
                }
                if (sign == '/') {
                    stk.push(stk.pop() / num);
                }
                sign = cur;
                num = 0;
            }
        }

        int res = 0;
        for (int i : stk) {
            res += i;
        }
        return res;
    }
}

/*
Verstion #2
public class Solution {
    public int calculate(String s) {
        int sum = 0;
        for (String t : s.replace(" ", "").split("(?=[+-])")){
            int term = 1;
            for (String u : ('*' + t).split("(?=[* /])")){
                int n = Integer.parseInt(u.substring(1));
                term = u.startsWith("*")? term * n : term / n;
            }
            sum += term;
        }
        return sum;
    }
}
*/

/*
Split the whole expression into terms on + and -. Split each term on * and /. 
Split with look-ahead, so the operators remain in the strings as the first character. Otherwise I'd lose them. 
I don't have to deal with +/- myself since parseInt will get the number including the +/- prefix and do it for me.

Reference:
https://leetcode.com/discuss/41790/10-16-lines-java-easy
*/
