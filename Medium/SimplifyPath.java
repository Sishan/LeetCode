/*
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
*/

class Solution {
    public String simplifyPath(String path) {

        if (path == null || path.length() == 0)
            return path;
        String[] ops = path.split("/");
        Deque<String> deque = new LinkedList<String>();

        for (String str : ops) {
            if (str.equals(".") || str.equals(""))
                continue;
            if (str.equals(".."))
                deque.pollFirst();
            else
                deque.offerFirst(str);
        }

        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            String str = deque.pollLast();
            sb.append("/");
            sb.append(str);
        }

        return (sb.length() == 0) ? "/" : sb.toString();
    }
}