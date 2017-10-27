/*
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/

class MovingAverage {
    private int sum;
    private int maxSize;
    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new LinkedList<Integer>();
        maxSize = size;
        sum = 0;
    }

    public double next(int val) {
        if (queue.size() == maxSize) {
            sum -= queue.remove();
        }
        queue.offer(val);
        sum += val;
        return (double) sum / queue.size();
    }
}


/*
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */

 /*
 // Another solution using int array as queue
 public class MovingAverage {
    private int [] window;
    private int n, insert;
    private long sum;
    
    public MovingAverage(int size) {
        window = new int[size];
        insert = 0;
        sum = 0;
    }
    
    public double next(int val) {
        if (n < window.length)  n++;
        sum -= window[insert];
        sum += val;
        window[insert] = val;
        insert = (insert + 1) % window.length;
        
        return (double)sum / n;
    }
}
*/