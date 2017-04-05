/*
All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.

Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.

For example,

Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",

Return:
["AAAAACCCCC", "CCCCCAAAAA"].
*/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<Integer> doubleWords = new HashSet<>();
        List<String> res = new ArrayList<>();
        char[] map = new char[26];
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
    
        for(int i = 0; i + 9 < s.length(); i++) {
            int value = 0;
            for(int j = i; j < i + 10; j++) {
                value <<= 2;
                value |= map[s.charAt(j) - 'A'];
            }
            if(!words.add(value) && doubleWords.add(value)) {
                res.add(s.substring(i, i + 10));
            }
        }
        return res;
    }
}


/*
Only four possible letters in the string, using bitmap idea. 
Record A == 00, C == 01, G == 10, T == 11, and therefore recording 10 letter string will only 
use 2 bits * 10 = 20 bits, while store 10 letter string will cost 2 bytes * 10 = 20 bytes

Below is the solution directly record substring
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<String>();
        Set<String> repeated = new HashSet<String>();
        
        for (int i = 0; i + 9 < s.length(); i++){
            String cur = s.substring(i, i + 10);
            if (!seen.add(cur)) repeated.add(cur);
        }
        return new ArrayList(repeated);
    }
}
*/