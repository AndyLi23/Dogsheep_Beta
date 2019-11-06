package Functions;

import java.util.ArrayList;

public class QuadCalc {
    public int[] simroot(int num) {
        int[] ans = new int[2];

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
                b=b*i;
            }
            ans[0]=b;
            ans[1] = num;
        }
    }
    public String calculate(double a, double b, double c) {
        return "";
    }
}
