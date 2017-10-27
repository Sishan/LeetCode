/*
Given a set of words (without duplicates), find all word squares you can build from them.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally and vertically.

b a l l
a r e a
l e a d
l a d y
Note:
There are at least 1 and at most 1000 words.
All words will have the exact same length.
Word length is at least 1 and at most 5.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
["area","lead","wall","lady","ball"]

Output:
[
  [ "wall",
    "area",
    "lead",
    "lady"
  ],
  [ "ball",
    "area",
    "lead",
    "lady"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each word square matters).
Example 2:

Input:
["abat","baba","atan","atal"]

Output:
[
  [ "baba",
    "abat",
    "baba",
    "atan"
  ],
  [ "baba",
    "abat",
    "baba",
    "atal"
  ]
]

Explanation:
The output consists of two word squares. The order of output does not matter (just the order of words in each wo
*/

public class Solution {
    class Node {
        Node[] children = new Node[26];
        String val = null;
    }

    private Node root = new Node();

    private void addToTrie(String s, Node root) {
        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (root.children[idx] == null) {
                root.children[idx] = new Node();
            }
            root = root.children[idx];
        }
        root.val = s;
    }

    private void findAllSquares(int row, int col, Node[] rows, List<List<String>> res) {
        if (row == rows.length) {
            List<String> temp = new ArrayList<>(rows.length);
            for (int i = 0; i < rows.length; i++){
                temp.add(rows[i].val);
            }
            res.add(temp);
        } else if (col < rows.length) {
            Node currow = rows[row];
            Node curcol = rows[col];
            for (int i = 0; i < 26; i++) {
                if (currow.children[i] != null && curcol.children[i] != null) {
                    rows[row] = currow.children[i];
                    rows[col] = curcol.children[i];
                    findAllSquares(row, col + 1, rows, res);
                }
            }
            rows[row] = currow;
            rows[col] = curcol;
        } else {
            findAllSquares(row + 1, row + 1, rows, res);
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0 || words[0] == null || words[0].length() == 0)
            return res;
        for (String s : words) {
            addToTrie(s, root);
        }
        Node[] rows = new Node[words[0].length()];
        Arrays.fill(rows, root);
        findAllSquares(0, 0, rows, res);
        return res;
    }
}