/*
The count-and-say sequence is the sequence of integers beginning as follows:
1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth sequence.

Note: The sequence of integers will be represented as a string.
*/

public class Solution {
	public String countAndSay(int n) {
		if (n <= 0)
			return "";
		String res = "1";
		for (int i = 1; i < n; i++) {
			int count = 1;
			StringBuilder new_res = new StringBuilder();
			for (int j = 1; j <= res.length(); j++) {
				if (j < res.length() && res.charAt(j) == res.charAt(j - 1))
					count++;
				else {
					new_res.append(count);
					new_res.append(res.charAt(j - 1));
					count = 1;
				}
			}
			res = new_res.toString();
		}
		return res;
	}
}

/*
Reference:
https://leetcode.com/discuss/37219/possible-solutions
https://leetcode.com/discuss/37355/java-solution-with-sorting-o-nlog-n-time-o-1-space
https://leetcode.com/discuss/37190/java-o-n-ac-solutions-with-hashset-and-bitset
*/
