/*
Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.

It is possible that several messages arrive roughly at the same time.

Example:

Logger logger = new Logger();

// logging string "foo" at timestamp 1
logger.shouldPrintMessage(1, "foo"); returns true; 

// logging string "bar" at timestamp 2
logger.shouldPrintMessage(2,"bar"); returns true;

// logging string "foo" at timestamp 3
logger.shouldPrintMessage(3,"foo"); returns false;

// logging string "bar" at timestamp 8
logger.shouldPrintMessage(8,"bar"); returns false;

// logging string "foo" at timestamp 10
logger.shouldPrintMessage(10,"foo"); returns false;

// logging string "foo" at timestamp 11
logger.shouldPrintMessage(11,"foo"); returns true;
*/

class Logger {
    HashMap<String, Integer> lookUp;

    /** Initialize your data structure here. */
    public Logger() {
        lookUp = new HashMap<String, Integer>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (lookUp.containsKey(message) && timestamp - lookUp.get(message) < 10) {
            return false;
        }
        lookUp.put(message, timestamp);
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */

// Algo thinking Queue
// time = O(N)

class TimeMsg {
    int timestamp;
    String msg;

    public TimeMsg(int timestamp, String msg) {
        this.timestamp = timestamp;
        this.msg = msg;
    }}

/** Initialize your data structure here. */
private static final int MAX_TIME_WINDOW = 10;

Queue<TimeMsg> msgQueue;

public Logger() {
    msgQueue = new LinkedList<>();
}

/** Returns true if the message should be printed in the given timestamp, otherwise returns false.
    If this method returns false, the message will not be printed.
    The timestamp is in seconds granularity. */
public boolean shouldPrintMessage(int timestamp, String message) {
    
    while (!msgQueue.isEmpty() && timestamp - msgQueue.peek().timestamp >= MAX_TIME_WINDOW) {
        msgQueue.poll();
    }
    
    Iterator<TimeMsg> iter = msgQueue.iterator();
    while (iter.hasNext()) {
        TimeMsg tm = iter.next();
        if (tm.msg.equals(message)) return false;
    }
    
    
    msgQueue.offer(new TimeMsg(timestamp, message));
    
    return true;
}