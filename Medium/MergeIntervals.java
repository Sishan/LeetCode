/*
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
*/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval obj0, Interval obj1) {
                return obj0.start - obj1.start;
            }
        });

        List<Interval> res = new ArrayList<>();
        Interval prev = null;
        for (Interval inter : intervals) {
            if (prev == null || inter.start > prev.end ) {
                res.add(inter);
                prev = inter;
            } 
            else if (inter.end > prev.end) {
                prev.end = inter.end;           // Modify the element already in list
            }
        }
        return res;
    }
}