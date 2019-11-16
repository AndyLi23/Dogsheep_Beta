package Functions;

import java.math.BigDecimal;
import java.util.Stack;

public class BasicCalc {

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
        boolean negative = false;

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);

            if(Character.isDigit(cur)) {
                if(!decimal) {
                    operand = 10 * operand + (cur - '0');
                    n += 1;
                } else {
                    operand = operand + (Math.pow(10, -n) * (cur - '0'));
                    n += 1;
                }
            } else if (cur != ' ') {
                if (cur == '.') {
                    decimal = true;
                    n = 1;
                } else if (cur == '-') {
                    negative = true;
                } else if (n != 0) {
                    if(negative) {
                        operand = -1 * operand;
                    }
                    ans += operand + " ";
                    operand = 0;
                    n = 0;
                    decimal = false;
                    negative = false;
                }

                if (cur == '(') {
                    stack.push(cur);
                } else if (cur == ')') {
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        ans += stack.pop() + " ";
                    }
                    stack.pop();
                } else if(!(cur == '.') && !(cur == '-')) {
                    while(!stack.isEmpty() && pref(cur) <= pref(stack.peek())) {
                        ans += stack.pop() + " ";
                    }
                    stack.push(cur);
                }
            }
        }
        if(n!= 0) {
            if(negative) {
                operand = -operand;
            }
            ans += operand + " ";
        }
        while(!stack.isEmpty()) {
            ans += stack.pop() + " ";
        }
        return ans;
    }

    public BigDecimal postfixCalc(String s){
        Stack<Object> stack = new Stack<>();
        String[] sList = s.split(" ");
        BigDecimal a, b;

        for(int i =0; i < sList.length; i++) {
            if(sList[i].equals("*")) {
                a =(BigDecimal) stack.pop();
                b =(BigDecimal) stack.pop();
                stack.push(b.multiply(a));
            } else if(sList[i].equals("/")) {
                a = (BigDecimal)  stack.pop();
                b = (BigDecimal)  stack.pop();
                stack.push(BigDecimal.valueOf(b.doubleValue()/a.doubleValue()));
            } else if(sList[i].equals("+")) {
                a = (BigDecimal)  stack.pop();
                b = (BigDecimal)  stack.pop();
                stack.push(b.add(a));
            } else if(sList[i].equals("-")) {
                a = (BigDecimal) stack.pop();
                b = (BigDecimal) stack.pop();
                stack.push(b.subtract(a));
            } else if(sList[i].equals("^")) {
                a = (BigDecimal) stack.pop();
                b = (BigDecimal) stack.pop();
                stack.push(BigDecimal.valueOf(Math.pow(b.doubleValue(),a.doubleValue())));
            } else {
                stack.push(BigDecimal.valueOf(Double.parseDouble(sList[i])));
            }
        }
        return (BigDecimal) stack.pop();
    }
}
