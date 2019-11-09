package Functions;

import java.util.ArrayList;

public class QuadCalc {
    public double[] simroot(int num) {
        boolean neg = false;
        if(num < 0) {
            num = -num;
            neg = true;
        }
        double[] ans = new double[2];

        ArrayList<Integer> roots= new ArrayList<Integer>();
        for(int i=2; i<num; i++) {
            if(num % (i*i) == 0) {
                num = num / (i * i);
                roots.add(i);
            }
        }
        if(!roots.isEmpty()) {
            int b = 1;
            for(int i = 0; i < roots.size(); i++) {
                b=b*roots.get(i);
            }
            ans[0]=b;
            if(neg) {
                ans[1] = -num;
            } else {
                ans[1] = num;
            }
            return ans;
        } else {
            ans[0] = 1;
            if(neg) {
                num = -num;
            }
            ans[1] = num;
            return ans;
        }
    }

    public double[] gcf(double num1, double num2, double num3) {
        int gcf = 1;
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        num3 = Math.abs(num3);
        for (int i = 1; i < num1+1; i++) {
            if(num1%i == 0 && num2%i == 0 && num3%i == 0) {
                gcf = Math.max(gcf, i);
            }
        }
        double[] gcfList = new double[3];
        gcfList[0] = num1 / gcf;
        gcfList[1] = num2 / gcf;
        gcfList[2] = num3 / gcf;
        return gcfList;
    }

    public String calculate(double[] coef) {
        double d = Math.sqrt((coef[1]*coef[1])-4*coef[0]*coef[2]);
        if (d == 0) {
            return Double.toString((-1 * coef[1] + d) / 2 * coef[0]);
        }
        else if ((int)d == d) {
            double sol1 = (-1 * coef[1] + d) / (2 * coef[0]);
            double sol2 = (-1 * coef[1] - d) / (2 * coef[0]);
            return (sol1 + ", " + sol2);
        }
        double[] e = new double[2];
        if ((int)(coef[1]*coef[1])-4*coef[0]*coef[2] != (coef[1]*coef[1])-4*coef[0]*coef[2]) {
            e[0] = 1 ;
            e[1] = (coef[1]*coef[1])-4*coef[0]*coef[2];
        } else {
            e = simroot((int)((coef[1]*coef[1])-4*coef[0]*coef[2]));
        }
        double[] g = gcf(coef[1],e[0],-2*coef[0]);

        if (g[1] == 1 || g[1] == 0) {
            return "(" + (int)(g[0] * -1) + "±√" + (int)(e[1]) + ")/" + (int)(2 * g[2]);
        } else {
            return "(" + (int)(g[0] * -1) + "±" + (int)(g[1]) + "√" + (int)(e[1]) + ")/" + (int)(2 * g[2]);
        }

    }
}
