package Functions;

import java.math.BigDecimal;
import java.math.BigInteger;

public class FibGen {
    public BigInteger getFib(double num) {
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        for(double i = 2; i < num+1; i++) {
            if(a.compareTo(b) == 0 || a.compareTo(b) == -1) {
                a = a.add(b);
            } else {
                b = a.add(b);
            }
        }
        if(a.compareTo(b) == 0 || a.compareTo(b) == -1) {
            return a;
        } else {
            return b;
        }
    }

    public String generateFib(int num) {
        String ans = "1: 1\n2: 1\n";
        if(num < 1) {
            return "Invalid input";
        } else if(num == 1) {
            return "1: 1";
        }
        BigInteger a = new BigInteger("1");
        BigInteger b = new BigInteger("1");
        for(int i =2; i < num+1; i++) {
            if(a.compareTo(b) == 0 || a.compareTo(b) == -1) {
                a = a.add(b);
                ans = ans + (i+1) + ": " + a + "\n";
            } else {
                b = a.add(b);
                ans = ans + (i+1) + ": " + b + "\n";
            }
        }
        return ans;
    }
}
