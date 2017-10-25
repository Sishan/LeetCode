/*
Given a number represented by an integer array, duplicate any number in position and return the maximun result
*/

public class Solution {
    public static void main(String[] args) {
        int[] res = duplicateNumber(new int[] { 1, 2, 4, 3, 5 });
        for (Integer i : res) {
            System.out.println(i);
        }
    }

    public static int[] duplicateNumber(int[] input) {
        if (input == null || input.length == 0) {
            return input;
        } else if (input.length == 1) {
            return new int[] { input[0], input[0] };
        }
        int len = input.length;
        int pos = 0;
        int[] res = new int[len + 1];
        for (int i = 0; i < len - 1; i++, pos++) {
            if (input[i] <= input[i + 1]) {
                res[pos] = input[i];
            } else {
                res[pos] = input[i];
                pos++;
                while (pos < len + 1) {
                    res[pos] = input[i];
                    pos++;
                    i++;
                }
                return res;
            }
        }
        res[pos] = res[pos + 1] = input[len - 1];
        return res;
    }
}
