/*
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

Example:

addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
Note:
You may assume that all words are consist of lowercase letters a-z.
*/

public class WordDictionary {

    public class Node
    {
        public Dictionary<char, Node> child = new Dictionary<char, Node>();
         public bool isWord;   
    }
    
    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        root.isWord = true;
    }
    
    /** Adds a word into the data structure. */
    public void AddWord(string word) {
        Node cur = root;
        foreach(char ch in word)
        {
            if (!cur.child.ContainsKey(ch))
            {
                cur.child.Add(ch, new Node());
            }
            cur = cur.child[ch];
        } 
        cur.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public bool Search(string word) {
        if (word == null)
        {
            return false;
        }
        return SearchHelper(0, root, word);
    }
    
    public bool SearchHelper(int idx, Node cur, string word) {
        if (idx == word.Length)
        {
            return cur.isWord;
        }
        
        char ch = word[idx];
        if (ch != '.')
        {
            if (!cur.child.ContainsKey(ch))
            {
                return false;
            }
            return SearchHelper(idx + 1, cur.child[ch], word);
        }
        
        foreach (var mapChar in cur.child)
        {
            if (SearchHelper(idx + 1, mapChar.Value, word))
            {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */