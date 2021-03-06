/*
Given a time represented in the format "HH:MM", form the next closest time by reusing the current digits. There is no limit on how many times a digit can be reused.

You may assume the given input string is always valid. For example, "01:34", "12:09" are all valid. "1:34", "12:9" are all invalid.

Example 1:

Input: "19:34"
Output: "19:39"
Explanation: The next closest time choosing from digits 1, 9, 3, 4, is 19:39, which occurs 5 minutes later.  It is not 19:33, because this occurs 23 hours and 59 minutes later.
Example 2:

Input: "23:59"
Output: "22:22"
Explanation: The next closest time choosing from digits 2, 3, 5, 9, is 22:22. It may be assumed that the returned time is next day's time since it is smaller than the input time numerically.
*/

class Solution {
    public String nextClosestTime(String time) {
        String timeNum = time.substring(0, 2) + time.substring(3);
        int[] digits = new int[4];
        int[] sorted = new int[4];
        int[] origin = new int[4];
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < timeNum.length(); i++) {
            int cur = (int) (timeNum.charAt(i) - '0');
            digits[i] = cur;
            sorted[i] = cur;
        }
        origin = Arrays.copyOf(digits, digits.length);
        Arrays.sort(sorted);

        digits[3] = replaceDigit(sorted, digits[3], 9);
        if (digits[3] > origin[3]) {
            return res.append(digits[0]).append(digits[1]).append(':').append(digits[2]).append(digits[3]).toString();
        }

        digits[2] = replaceDigit(sorted, digits[2], 5);
        if (digits[2] > origin[2]) {
            return res.append(digits[0]).append(digits[1]).append(':').append(digits[2]).append(digits[3]).toString();
        }

        if (digits[0] == 2){
            digits[1] = replaceDigit(sorted, digits[1], 3);
        } else {
            digits[1] = replaceDigit(sorted, digits[1], 9);
        }
        if (digits[1] > origin[1]) {
            return res.append(digits[0]).append(digits[1]).append(':').append(digits[2]).append(digits[3]).toString();
        }

        digits[0] = replaceDigit(sorted, digits[0], 2);
        return res.append(digits[0]).append(digits[1]).append(':').append(digits[2]).append(digits[3]).toString();
    }

    public int replaceDigit(int[] sorted, int cur, int upperBound) {
        if (cur == upperBound || cur == sorted[3]) {
            return sorted[0];
        }
        int replace = cur;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] > upperBound) {
                return sorted[0];
            }
            if (sorted[i] > replace) {
                replace = sorted[i];
                break;
            }
        }
        return replace;
    }
}
