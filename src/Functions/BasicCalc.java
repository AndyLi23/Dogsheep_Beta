package Functions;

import java.util.Stack;

public class BasicCalc {
    public double evaluateExpr(Stack<Object> stack) {
        double res = 0;

        if (!stack.empty()) {
            res = (double) stack.pop();
        }

        while (!stack.empty() && !((char) stack.peek() == ')')) {
            char sign = (char) stack.pop();

            if (sign == '+') {
                res += (double) stack.pop();
            } else if (sign == '-'){
                res -= (double) stack.pop();
            } else if (sign == '/') {
                res = res / (double) stack.pop();
            } else if (sign == '*'){
                res = res * (double) stack.pop();
            } else if (sign == '^') {
                res = Math.pow(res, (double) stack.pop());
            }
        }
        return res;
    }

    public double calculate(String s) {

        double operand = 0;
        int n = 0;
        Stack<Object> stack = new Stack<Object>();

        for (int i = s.length() - 1; i >= 0; i--) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                operand = Math.pow(10, n) * (double) (ch - '0') + operand;
                n += 1;

            } else if (ch != ' ') {
                if (ch == '.') {
                    operand = Math.pow(10, -n) * operand;
                    n = 0;
                } else if (n != 0) {
                    System.out.println(operand);
                    stack.push(operand);
                    n = 0;
                    operand = 0;

                }
                if (ch == '(') {

                    double res = evaluateExpr(stack);
                    stack.pop();
                    stack.push(res);

                } else {
                    stack.push(ch);
                }
            }
        }
        if (n != 0) {
            stack.push(operand);
            System.out.println(operand);
        }
        return evaluateExpr(stack);
    }
}
