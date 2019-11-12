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

    public int pref(char ch)
    {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    public String postfix(String s) {
        Stack<Character> stack = new Stack<>();
        String ans = "";

        int n = 0;
        double operand = 0;
        boolean decimal = false;


        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(Character.isDigit(cur)) {
                if(!decimal) {
                    operand = Math.pow(10, n) * operand + (cur - '0');
                    n += 1;
                } else {
                    operand = operand + Math.pow(10, n) * (cur - '0');
                    n -= 1;
                }
            } else if (cur != ' ') {
                if (cur == '.') {
                    decimal = true;
                    n = -1;
                } else if (n != 0) {
                    ans += operand + " ";
                    operand = 0;
                    n = 0;
                    decimal = false;
                }

                if (cur == '(') {
                    stack.push(cur);
                } else if (cur == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        ans += stack.pop();
                    }
                    stack.pop();
                } else if(!(cur == '.')) {
                    while(!stack.isEmpty() && pref(cur) <= pref(stack.peek())) {
                        ans += String.valueOf(stack.pop());
                    }
                    stack.push(cur);
                }
            }
        }
        if(n!= 0) {
            ans += operand + " ";
        }
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }

    public double postfixCalc(String s){
        return 0;
    }
}
