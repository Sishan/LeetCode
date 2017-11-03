/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
Note:
You may assume that all inputs are consist of lowercase letters a-z.
*/

class Solution {
    class TireNode{
        TireNode[] children;
        String word;
        
        public TireNode(){
            children = new TireNode[26];
            word = null;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<String>();
        if (board == null || board.length == 0 || board[0].length == 0){
            return res;
        }
        TireNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }
    
    public TireNode buildTrie(String[] words){
        TireNode root = new TrieNode();
        for (String word : words){
            TireNode p = root;
            for (int i = 0; i < word.length(); i++){
                char c = word.charAt(i);
                if (p.children[c - 'a'] == null){
                    p.children[c - 'a'] = new TireNode();
                }
                p = p.children[c - 'a'];
            }
            p.word = word;
        }
        return root;
    }
    
    public void dfs(char[][] board, int i, int j, TireNode root, List<String> res){
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null){
            return;
        }
        root = root.children[c - 'a'];
        if (root.word != null){
            res.add(root.word);
            root.word = null;
        }
        
        board[i][j] = '#';
        if (i > 0){
            dfs(board, i - 1, j, root, res);
        }
        if (j > 0){
            dfs(board, i, j - 1, root, res);
        }
        if (i < board.length - 1){
            dfs(board, i + 1, j, root, res);
        }
        if (j < board[0].length - 1){
            dfs(board, i, j + 1, root, res);
        }
        board[i][j] = c;
    }
}