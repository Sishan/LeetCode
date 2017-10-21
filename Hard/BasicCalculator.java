/*Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
Note: Do not use the eval built-in library function.

Subscribe to see which companies asked this question
*/

public class Solution {
    public int calculate(String s) {
        int res = 0;
        int sign = 1;
        int number = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.chatAt(i);
            if (Character.isDigit(c)) { // c >= '0' && c <= '9'
                number = number * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                stack.push(res); // we push the result first, then sign;
                stack.push(sign); // reset the sign and result for the value in the parenthesis
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * number;
                number = 0;
                res *= stack.pop(); // stack.pop() is the sign before the parenthesis
                res += stack.pop(); // stack.pop() now is the result calculated before the parenthesis
            }
        }
        if (number != 0)
            res += number * sign;
        return res;
    }
}

/*
Simple iterative solution by identifying characters one by one. One important thing is that the input is valid, which means the parentheses are always paired and in order. Only 5 possible input we need to pay attention:
digit: it should be one digit from the current number
'+': number is over, we can add the previous number and start a new number
'-': same as above
'(': push the previous result and the sign into the stack, set result to 0, just calculate the new result within the parenthesis.
')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second is the temporary result before this pair of parenthesis. We add them together.
Finally if there is only one number, from the above solution, we haven't add the number to the result, so we do a check see if the number is zero.

Reference:
https://leetcode.com/discuss/39553/iterative-java-solution-with-stack
https://leetcode.com/discuss/39454/accepted-infix-postfix-based-solution-explaination-600ms
https://leetcode.com/discuss/39457/accepted-solution-understood-explanations-convert-postfix
https://leetcode.com/discuss/39481/concise-solution-using-recursion-postfix-convertion-needed
https://leetcode.com/discuss/39845/java-solution-with-stream-api-stack-and-reg-expression
https://leetcode.com/discuss/39511/solution-based-on-postfix-conversion
*/
