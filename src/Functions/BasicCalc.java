package Functions;

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
                        ans += stack.pop() + " ";
                    }
                    stack.pop();
                } else if(!(cur == '.')) {
                    while(!stack.isEmpty() && pref(cur) <= pref(stack.peek())) {
                        ans += stack.pop() + " ";
                    }
                    stack.push(cur);
                }
            }
        }
        if(n!= 0) {
            ans += operand + " ";
        }
        while(!stack.isEmpty()) {
            ans += stack.pop() + " ";
        }
        return ans;
    }

    public double postfixCalc(String s){
        Stack<Object> stack = new Stack<>();
        String[] sList = s.split(" ");
        double a, b;

        for(int i =0; i < sList.length; i++) {
            if(sList[i].equals("*")) {
                a = (double) stack.pop();
                b = (double) stack.pop();
                stack.push(b * a);
            } else if(sList[i].equals("/")) {
                a = (double) stack.pop();
                b = (double) stack.pop();
                stack.push(b/a);
            } else if(sList[i].equals("+")) {
                a = (double) stack.pop();
                b = (double) stack.pop();
                stack.push(b+a);
            } else if(sList[i].equals("-")) {
                a = (double) stack.pop();
                b = (double) stack.pop();
                stack.push(b-a);
            } else if(sList[i].equals("^")) {
                a = (double) stack.pop();
                b = (double) stack.pop();
                stack.push(Math.pow(b,a));
            } else {
                stack.push(Double.parseDouble(sList[i]));
            }
        }
        return (double) stack.pop();
    }
}
