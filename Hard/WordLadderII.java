/*

Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:

Only one letter can be changed at a time
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
Return
  [
    ["hit","hot","dot","dog","cog"],
    ["hit","hot","lot","log","cog"]
  ]
Note:
Return an empty list if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
UPDATE (2017/1/20):
The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
*/

class Solution {
    List<List<String>> results;
    Map<String, List<String>> map;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        results = new ArrayList<List<String>>();
        map = new HashMap<String, List<String>>();

        if (wordList.size() == 0)
            return results;
        Map<String, Integer> ladder = new HashMap<String, Integer>();

        int min = Integer.MAX_VALUE;
        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        for (String word : wordList) {
            ladder.put(word, Integer.MAX_VALUE);
        }

        ladder.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            int step = ladder.get(word) + 1;

            if (step > min)
                break;

            for (int i = 0; i < word.length(); i++) {
                StringBuilder tmp = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    tmp.setCharAt(i, ch);
                    String new_word = tmp.toString();

                    if (ladder.containsKey(new_word)) {
                        if (step > ladder.get(new_word)) {
                            continue;
                        } else if (step < ladder.get(new_word)) {
                            queue.add(new_word);
                            ladder.put(new_word, step);
                        } else
                            ;

                        if (map.containsKey(new_word)) {
                            map.get(new_word).add(word);
                        } else {
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(word);
                            map.put(new_word, list);
                        }
                    }

                    if (new_word.equals(endWord)) {
                        min = step;
                    }
                }
            }
        }
        ArrayList<String> result = new ArrayList<String>();
        backTrack(endWord, beginWord, result, map);
        return results;
    }

    public void backTrack(String word, String start, List<String> list, Map<String, List<String>> map) {
        if (word.equals(start)) {
            list.add(0, start);
            results.add(new ArrayList<String>(list));
            list.remove(0);
            return;
        }
        list.add(0, word);

        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                System.out.println(s);
                backTrack(s, start, list, map);
            }
        }
        list.remove(0);

    }
}

/*
Reference：
https://discuss.leetcode.com/topic/2857/share-two-similar-java-solution-that-accpted-by-oj


*/