/*
Given a List of words, return the words that can be typed using letters of alphabet on only one row's of American keyboard like the image below.


American keyboard


Example 1:
Input: ["Hello", "Alaska", "Dad", "Peace"]
Output: ["Alaska", "Dad"]
Note:
You may use one character in the keyboard more than once.
You may assume the input string will only contain letters of alphabet.

*/

class Solution {
    public String[] findWords(String[] words) {
        String[] strs = new String[] { "QWERTYUIOP", "ASDFGHJKL", "ZXCVBNM" };
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()) {
                map.put(c, i);
            }
        }

        List<String> tmp = new ArrayList<String>();
        for (String word : words) {
            if (word.equals("")) {
                continue;
            }
            int index = map.get(word.toUpperCase().charAt(0));
            for (char c : word.toUpperCase().toCharArray()) {
                if (map.get(c) != index) {
                    index = -1;
                    break;
                }
            }

            if (index != -1) {
                tmp.add(word);
            }
        }
        String[] res = new String[tmp.size()];
        return tmp.toArray(res);
    }
}