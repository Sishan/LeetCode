/*
A group of friends went on holiday and sometimes lent each other money. For example, Alice paid for Bill's lunch for $10. Then later Chris gave Alice $5 for a taxi ride. We can model each transaction as a tuple (x, y, z) which means person x gave person y $z. Assuming Alice, Bill, and Chris are person 0, 1, and 2 respectively (0, 1, 2 are the person's ID), the transactions can be represented as [[0, 1, 10], [2, 0, 5]].

Given a list of transactions between a group of people, return the minimum number of transactions required to settle the debt.

Note:

A transaction will be given as a tuple (x, y, z). Note that x ≠ y and z > 0.
Person's IDs may not be linear, e.g. we could have the persons 0, 1, 2 or we could also have the persons 0, 2, 6.
Example 1:

Input:
[[0,1,10], [2,0,5]]

Output:
2

Explanation:
Person #0 gave person #1 $10.
Person #2 gave person #0 $5.

Two transactions are needed. One way to settle the debt is person #1 pays person #0 and #2 $5 each.
Example 2:

Input:
[[0,1,10], [1,0,1], [1,2,5], [2,0,5]]

Output:
1

Explanation:
Person #0 gave person #1 $10.
Person #1 gave person #0 $1.
Person #1 gave person #2 $5.
Person #2 gave person #0 $5.

Therefore, person #1 only need to give person #0 $4, and all debt is settled.
*/

class Solution {
    public int minTransfers(int[][] transactions) {
        if (transactions == null || transactions.length == 0 || transactions[0].length == 0) {
            return 0;
        }
        HashMap<Integer, Long> map = new HashMap<Integer, Long>();
        for (int[] trans : transactions) {
            map.put(trans[0], map.getOrDefault(trans[0], 0L) - trans[2]);
            map.put(trans[1], map.getOrDefault(trans[1], 0L) + trans[2]);
        }

        List<Long> list = new ArrayList<Long>();
        for (Integer i : map.keySet()) {
            if (map.get(i) != 0) {
                list.add(map.get(i));
            }
        }

        Long[] debts = new Long[list.size()];
        debts = list.toArray(debts);
        Arrays.sort(debts);
        return helper(debts, 0, 0);
    }

    public int helper(Long[] debts, int pos, int count) {
        while (pos < debts.length && debts[pos] == 0) {
            pos++;
        }
        int res = Integer.MAX_VALUE;
        long pre = 0;
        for (int i = pos + 1; i < debts.length; i++) {
            if (debts[i] != pre && debts[pos] * debts[i] < 0) {
                debts[i] += debts[pos];
                res = Math.min(res, helper(debts, pos + 1, count + 1));
                debts[i] -= debts[pos];
                pre = debts[i];
            }
        }
        return res == Integer.MAX_VALUE ? count : res;
    }
}