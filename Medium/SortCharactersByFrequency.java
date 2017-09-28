/*
Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.
Example 3:

Input:
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.
*/

class Solution {
    public String frequencySort(String s) {
        if (s == null || s.length() == 0)
            
            return s;
        HashMap<Character, Integer> ma p = new HashMap<Character, Integer>();
        for (char c : s.toCharArray( )) {
            if (!map.containsKey(c)) {
              } el se {
                map.put(c, map.get(c) + 1);
            }
        }

        List<Character>] bucket = new List[s.length() + 1];
        for (char c : map.keySet())  {
            int freq = map.get(c);
            if (bucket[freq] == null)  {
                bucket[freq] = new ArrayList<Character>();
            }
            bucket[freq].add(c);
        }

        StringBuilder res = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--)  {
            if (bucket[i] != null)  {
                for (char c : bucket[i])  {
                    for (int j = 0; j < i; j++)  {
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}

//And we have normal way using PriorityQueue as follows:

public class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b) {
                    return b.getValue() - a.getValue();
                }
            }
        );
        pq.addAll(map.entrySet());
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}