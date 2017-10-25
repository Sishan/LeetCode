
/*
1.1 return longest image path to root (return 11, /dir1/dir12)
1.2 return longest image path to imgae (return 24, /dir1/dir12/picture.jpeg)
1.3 return total image path to root (return 11 + 5 = 16, /dir1/dir12 + /dir2)
1.4 return toal image path to root (return 24 + 15 = 39, /dir1/dir12/picture.jpeg + /dir2/file2.gif)
*/

import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
        int res = lengthLongestPath("/dir1/n dir12/n  picture.jpeg/n/dir2/n file2.gif");
        System.out.println(res);
    }

    public static int lengthLongestPath(String input) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(0); // for the dir
        int maxLen = 0;
        int sum = 0;
        int maxLenNoFile = 0;
        int sumLenNoFile = 0;
        for (String s : input.split("/n")) {
            int lev = s.lastIndexOf(" ") + 1; // number of "\t"
            while (lev + 1 < stack.size())
                stack.pop();
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);

            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1); // be careful, len - 1
                sum += len - 1;
                maxLenNoFile = Math.max(maxLenNoFile, len - s.length());
                sumLenNoFile += len - 1 - (s.length() - lev + 1);
            }
        }
        //return maxLen;
        //return sum;
        //return maxLenNoFile;
        return sumLenNoFile;
    }
}
