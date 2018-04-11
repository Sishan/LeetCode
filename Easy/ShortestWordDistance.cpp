/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

For example,
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Given word1 = “coding”, word2 = “practice”, return 3.
Given word1 = "makes", word2 = "coding", return 1.

Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

class Solution {
public:
    int shortestDistance(vector<string>& words, string word1, string word2) {
        int min = words.size();
        int last1 = - words.size();
        int last2 = - words.size();
        for (int i = 0; i < words.size(); i++) {
            if (words[i] == word1) {
                last1 = i;
                min = std::min(min, last1 - last2);
            }
            if (words[i] == word2) {
                last2 = i;
                min = std::min(min, last2 - last1);
            }
        }
        return min;
    }
};