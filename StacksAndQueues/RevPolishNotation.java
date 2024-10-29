package StacksAndQueues;

import java.util.Stack;

public class RevPolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(isNumeric(tokens[i])){
                stack.push(Integer.parseInt(tokens[i]));
            }else{
                if(tokens[i].equals("+")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = num1 + num2;
                    stack.push(res);
                }
                if(tokens[i].equals("-")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = num1 - num2;
                    stack.push(res);
                }
                if(tokens[i].equals("*")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = num1 * num2;
                    stack.push(res);
                }
                if(tokens[i].equals("/")){
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    int res = num1 / num2;
                    stack.push(res);
                }
            }
        }
        return stack.peek();
    }

    public boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
    
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
