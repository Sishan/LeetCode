/*
Given a positive integer, return its corresponding column title as appear in an Excel sheet.
For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB 
*/

public class Solution {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (n > 0){
        	int temp = n % 26;
        	n = n / 26;
        	if (temp == 0){                                 // two case, 'Z' or others
        		sb.insert(0,'Z');     
        		n--;                                         // when 'Z' is the end title, mod operation need to minus extra one
        	}
        	else {
        		sb.insert(0, (char)(temp + 64));             // 64 comes from temp - 1 + 'A'
        	}
        }
        return sb.toString();
    }
}

/*
Mthods:
stringbuilder.insert()
stringbuilder.toString()
*/