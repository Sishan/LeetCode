/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

public class Solution{
	public String addBinary(String a, String b){
		StringBuilder sb = new StringBuilder();
		Boolean carry = false;
		int i = a.length()-1;
		int j = b.length()-1;

		while (i>=0 || j>=0 || carry == true){
			char achar = '0';
			char bchar = '0';
			int counter = 0;
			if (i >= 0) achar = a.charAt(i);
			if (j >= 0) bchar = b.charAt(j);

			if (achar == '1') counter++;
			if (bchar == '1') counter++;
			if (carry == true) counter++;

			if (counter > 1) carry = true;
			else carry = false;

			if (counter % 2 == 1) sb.insert(0,'1');
			else sb.insert(0,'0');

			i--;
			j--;
		} 
		return sb.toString();
	}
}
