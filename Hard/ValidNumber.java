/*
Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.
*/

class Solution {
    public boolean isNumber(String s) {
        s = s.trim();

        int state = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '+' || cur == '-') {
                if (state == 0 || state == 3) {
                    state++;
                } else {
                    return false;
                }
            } else if (cur == '.') {
                if (state == 0 || state == 1) {
                    state = 6;
                } else if (state == 2) {
                    state = 7;
                } else {
                    return false;
                }
            } else if (cur >= '0' && cur <= '9') {
                if (state == 0 || state == 3) {
                    state += 2;
                } else if (state == 1 || state == 4 || state == 6) {
                    state++;
                }
            } else if (cur == 'e' || cur == 'E') {
                if (state == 2 || state == 7) {
                    state = 3;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return (state == 2 || state == 7 || state == 5);
    }
}

/*
deterministic finite automaton (DFA)

s0 -- (+/-) --> s1 
s3 -- (+/-) --> s4

s0 -- (.) --> s6
s1 -- (.) --> s6
s2 -- (.) --> s7

s0 -- (digit) --> s2
s3 -- (digit) --> s5
s1 -- (digit) --> s2
s4 -- (digit) --> s5
s6 -- (digit) --> s7

s2 -- (e) --> s3
s7 -- (e) --> s3
*/