/*
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

For example,
Given [[0, 30],[5, 10],[15, 20]],
return 2.
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
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int n = intervals.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        int room = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (starts[i] < ends[endIndex]) {
                room++;
            } else {
                endIndex++;
            }
        }
        return room;
    }
}

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        PriorityQueue<Interval> queue = new PriorityQueue<Interval>((i1, i2) -> i1.end - i2.end);

        queue.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            Interval cur = queue.poll();

            if (intervals[i].start >= cur.end) {
                cur.end = intervals[i].end;
            } else {
                queue.offer(intervals[i]);
            }

            queue.offer(cur);
        }
        return queue.size();
    }
}