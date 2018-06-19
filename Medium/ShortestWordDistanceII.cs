/*
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters. 

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/

public class WordDistance {

    Dictionary<string, List<int>> map;
    
    public WordDistance(string[] words) {
        this.map = new Dictionary<string, List<int>>();
        
        for (int i = 0; i < words.Length; i++) 
        {
            if (!map.ContainsKey(words[i]))
            {
                map[words[i]] = new List<int>();
            }
            map[words[i]].Add(i);
        }
    }
    
    public int Shortest(string word1, string word2) {
        List<int> list1 = this.map[word1];
        List<int> list2 = this.map[word2];
        
        int idx1 = 0;
        int idx2 = 0;
        int min = int.MaxValue;
        while (idx1 < list1.Count && idx2 < list2.Count)
        {
            min = Math.Min(min, Math.Abs(list1[idx1] - list2[idx2]));
            if (list1[idx1] < list2[idx2])
            {
                idx1++;
            }
            else 
            {
                idx2++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.Shortest(word1,word2);
 */