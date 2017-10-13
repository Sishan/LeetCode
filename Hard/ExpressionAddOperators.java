/*
Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Examples: 
"123", 6 -> ["1+2+3", "1*2*3"] 
"232", 8 -> ["2*3+2", "2+3*2"]
"105", 5 -> ["1*0+5","10-5"]
"00", 0 -> ["0+0", "0-0", "0*0"]
"3456237490", 9191 -> []
*/

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        helper(res, new StringBuilder(), num, target, 0, 0, 0);
        return res;
    }
    
    public void helper(List<String> res, StringBuilder path, String num, int target, int pos, long val, long multed){
        if (pos == num.length()){
            if (val == target){
                res.add(path.toString());
                return;
            }
        }
        
        for (int i = pos; i < num.length(); i++){
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();
            if (pos == 0){
                helper(res, path.append(cur), num, target, i + 1, cur, cur);
                path.setLength(len);
            }
            else{
                helper(res, path.append("+").append(cur), num, target, i + 1, val + cur, cur);
                path.setLength(len);
                helper(res, path.append("-").append(cur), num, target, i + 1, val - cur, -cur);
                path.setLength(len);
                helper(res, path.append("*").append(cur), num, target, i + 1, val - multed + multed * cur, multed * cur);
                path.setLength(len);
            }
        }
    }
}