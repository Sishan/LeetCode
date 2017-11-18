/*
There are some trees, where each tree is represented by (x,y) coordinate in a two-dimensional garden. Your job is to fence the entire garden using the minimum length of rope as it is expensive. The garden is well fenced only if all the trees are enclosed. Your task is to help find the coordinates of trees which are exactly located on the fence perimeter.

Example 1:
Input: [[1,1],[2,2],[2,0],[2,4],[3,3],[4,2]]
Output: [[1,1],[2,0],[4,2],[3,3],[2,4]]
Explanation:

Example 2:
Input: [[1,2],[2,2],[4,2]]
Output: [[1,2],[2,2],[4,2]]
Explanation:

Even you only have trees in a line, you need to use rope to enclose them. 
Note:

All trees should be enclosed together. You cannot cut the rope to enclose trees that will separate them in more than one group.
All input integers will range from 0 to 100.
The garden has at least one tree.
All coordinates are distinct.
Input points have NO order. No order required for output.
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
class Solution {
    public List<Point> outerTrees(Point[] points) {
        if (points.length <= 1) {
            return Arrays.asList(points);
        }
        sortedByPolar(points, findBottomLeft(points));
        Stack<Point> stk = new Stack<Point>();
        stk.push(points[0]);
        stk.push(points[1]);

        for (int i = 2; i < points.length; i++) {
            Point top = stk.pop();
            while (ccw(stk.peek(), top, points[i]) < 0) {
                top = stk.pop();
            }
            stk.push(top);
            stk.push(points[i]);
        }
        return new ArrayList<>(stk);
    }

    public Point findBottomLeft(Point[] points) {
        Point res = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i].y < res.y || (points[i].y == res.y && points[i].x < res.x)) {
                res = points[i];
            }
        }
        return res;
    }

    //return positive if counter-clockwise, negative if clockwise, zero if collinear
    public int ccw(Point a, Point b, Point c) {
        return a.x * b.y - a.y * b.x + b.x * c.y - b.y * c.x + c.x * a.y - c.y * a.x;
    }

    public int dist(Point p, Point q) {
        return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
    }

    public void sortedByPolar(Point[] points, Point start) {
        Arrays.sort(points, (p, q) -> {
            int comPolar = ccw(p, start, q);
            int comDist = dist(p, start) - dist(q, start);
            return comPolar == 0 ? comDist : comPolar;
        });

        Point p = points[0], q = points[points.length - 1];
        int i = points.length - 2;
        while (i >= 0 && ccw(p, q, points[i]) == 0) {
            i--;
        }
        int lo = i + 1, hi = points.length - 1;
        while (lo < hi) {
            Point tmp = points[lo];
            points[lo] = points[hi];
            points[hi] = tmp;
            lo++;
            hi--;
        }
    }
}