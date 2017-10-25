/*
    1.1 replace two adjacent digits with the larger one， return min (e.g. 233614 -> 23364)
    1.2 replace two adjacent digits with the round up average， return max (e.g. 623315 -> 63315)
    1.3 choose a group of(at least two) identical adjacent and remove a single digit， return max (e.g.223336226 -> 23336226)
*/

package duplicates;

public class Solution {
    public static void main(String[] args) {
        //int res = rLrMin(22222);
        //int res = rRrMax(1123315);
        int res = rDrMax(223336226);
        System.out.println(res);

    }

    // replace larger return min
    public static int rLrMin(int x) {
        String res = "";
        String input = String.valueOf(x);
        for (int i = 0; i < input.length() - 2; i++) {
            char cur = input.charAt(i);
            char next = input.charAt(i + 1);
            StringBuilder tmp = new StringBuilder(input.substring(0, i));
            if (cur > next) {
                tmp.append(cur);
            } else {
                tmp.append(next);
            }
            if (i == input.length() - 2) {
                if (res.compareTo(tmp.toString()) > 0) {
                    res = tmp.toString();
                }
            } else {
                tmp.append(input.substring(i + 2));
            }
            if (res == "") {
                res = tmp.toString();
            } else if (res.compareTo(tmp.toString()) > 0) {
                res = tmp.toString();
            }
        }
        return Integer.valueOf(res);
    }

    // replace round up average return max
    public static int rRrMax(int x) {
        String res = "";
        String input = String.valueOf(x);
        for (int i = 0; i < input.length() - 2; i++) {
            char cur = input.charAt(i);
            char next = input.charAt(i + 1);
            StringBuilder tmp = new StringBuilder(input.substring(0, i));
            double avg = (double) (cur - '0' + next - '0') / 2.0;
            tmp.append((int) (Math.ceil(avg)));
            if (i == input.length() - 2) {
                if (res.compareTo(tmp.toString()) < 0) {
                    res = tmp.toString();
                }
            } else {
                tmp.append(input.substring(i + 2));
            }
            if (res == "") {
                res = tmp.toString();
            } else if (res.compareTo(tmp.toString()) < 0) {
                res = tmp.toString();
            }
        }
        return Integer.valueOf(res);
    }

    // replace duplicates return max
    public static int rDrMax(int x) {
        String res = "";
        String input = String.valueOf(x);
        for (int i = 0; i < input.length() - 2; i++) {
            char cur = input.charAt(i);
            char next = input.charAt(i + 1);
            StringBuilder tmp = new StringBuilder(input.substring(0, i));
            if (cur == next) {
                tmp.append(cur);
                i++;
            } else {
                tmp.append(cur);
            }
            if (i == input.length() - 2) {
                if (res.compareTo(tmp.toString()) < 0) {
                    res = tmp.toString();
                }
            } else {
                tmp.append(input.substring(i + 1));
            }
            if (res == "") {
                res = tmp.toString();
            } else if (res.compareTo(tmp.toString()) < 0) {
                res = tmp.toString();
            }
        }
        return Integer.valueOf(res);
    }
}
