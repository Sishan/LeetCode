/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  */

public class Solution {
    public int evalRPN(String[] a) {
      Stack<Integer> stack = new Stack<Integer>();
      for (int i = 0; i < a.length; i++) {
        switch (a[i]) {
          case "+":
            stack.push(stack.pop() + stack.pop());
            break;
          case "-":
            stack.push(-stack.pop() + stack.pop());
            break;
          case "*":
            stack.push(stack.pop() * stack.pop());
            break;
          case "/":
            int n1 = stack.pop(), n2 = stack.pop();
            stack.push(n2 / n1);
            break;
          default:
            stack.push(Integer.parseInt(a[i]));
            break;
        }
      }
      
      return stack.pop();
    }
}

/*
  public class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++){
            if (!tokens[i].equals("+") && !tokens[i].equals("-") && !tokens[i].equals("*") && !tokens[i].equals("/") ){
                stack.push(Integer.valueOf(tokens[i]));
            } 
            else calculate(stack, tokens[i]);
        }
        return stack.pop();
    }
    
    public void calculate(Stack<Integer> stack, String symbol){
        int x1 = stack.pop();
        int x2 = stack.pop();
        if (symbol.equals("+")) stack.push(x2 + x1);
        else if (symbol.equals("-")) stack.push(x2 - x1);
        else if (symbol.equals("*")) stack.push(x2 * x1);
        else if (symbol.equals("/")) stack.push(x2 / x1);
    }
}
*/

/*
Using stack to record the number, once find symbol, pop the last two, finish the calculation and then push back into the stack
*/