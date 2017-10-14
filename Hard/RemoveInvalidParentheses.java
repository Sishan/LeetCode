/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]
*/

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        remove(res, s, new char[] { '(', ')' }, 0, 0);
        return res;
    }

    public void remove(List<String> res, String s, char[] par, int last_i, int last_j) {
        for (int stack = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(res, s.substring(0, j) + s.substring(j + 1, s.length()), par, i, j);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            remove(res, reversed, new char[] { ')', '(' }, 0, 0);
        } else {
            res.add(reversed);
        }
    }
}