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
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<Integer, Map<Integer, Integer>>();
        int res = 0;
        for (int i = 0; i < points.length; i++){
            map.clear();
            int overlap = 0, max = 0;
            for (int j = i + 1; j < points.length; j++){
                int x = points[j].x - points[i].x;
                int y = points[j].y - points[i].y;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = generateGcd(x,y);
                if (gcd != 0){
                    x /= gcd;
                    y /= gcd;
                }
                if (map.containsKey(x)){
                    if (map.get(x).containsKey(y)) map.get(x).put(y, map.get(x).get(y)+1);
                    else map.get(x).put(y,1);
                }
                else{
                    Map<Integer, Integer> m = new HashMap<Integer, Integer>();
                    m.put(y,1);
                    map.put(x, m);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + overlap + 1);
        }
        return res;
    }
    
    public int generateGcd(int x, int y){               // return the greatest common divisor
        return y == 0 ? x : generateGcd(y, x % y);
    }
}