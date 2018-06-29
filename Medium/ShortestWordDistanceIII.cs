/*
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
word1 and word2 may be the same and they represent two individual words in the list.
Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
*/

public class Solution {
    public int ShortestWordDistance(string[] words, string word1, string word2) {
        int res = int.MaxValue;
        if (word1.Equals(word2))
        {
            int pos = -1;
            for (int i = 0; i < words.Length; i++)
            {
                if (!words[i].Equals(word1))
                {
                    continue;
                }
                if (pos != -1)
                {
                    res = Math.Min(res, i - pos);
                }
                pos = i;
            }
            return res;
        }
        
        int pos1 = -1;
        int pos2 = -1;
        
        for (int j = 0; j < words.Length; j++)
        {
            string word = words[j];
            if (word.Equals(word1))
            {
                pos1 = j;
                if (pos2 != -1)
                {
                    res = Math.Min(res, pos1 - pos2);
                }

            }
            else if (word.Equals(word2))
            {
                pos2 = j;
                if (pos1 != -1)
                {
                    res = Math.Min(res, pos2 - pos1);
                }
            }
        }
        return res;
    }
}