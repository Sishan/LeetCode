/*
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
*/

/**
* Definition for a point.
* class Point {
*     int x;
*     int y;
*     Point() { x = 0; y = 0; }
*     Point(int a, int b) { x = a; y = b; }
* }
*/
public class Solution {
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }
        int res = 0;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < points.length; i++) {
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;

                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }

                int gcd = gcd(x, y);
                if (gcd != 0) {
                    x /= gcd;
                    y /= gcd;
                }

                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else {
                        map.get(x).put(y, 1);
                    }
                } else {
                    HashMap<Integer, Integer> pair_count = new HashMap<Integer, Integer>();
                    pair_count.put(y, 1);
                    map.put(x, pair_count);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}