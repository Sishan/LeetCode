/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<String>();
        Set<String> map = new HashSet<String>();
        visited.add(beginWord);
        for (String word : wordList){
            map.add(word);
        }
        int distance = 1;
        
        while(!visited.contains(endWord)){
            Set<String> toAdd = new HashSet<String>();
            for (String s: visited){
                for (int i = 0; i < s.length(); i++){
                    char[] cur = s.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++){
                        cur[i] = ch;
                        String newWord = new String(cur);
                        if (map.contains(newWord)){
                            toAdd.add(newWord);
                            map.remove(newWord);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            visited = toAdd;
        }
        
        return distance;
    }
}