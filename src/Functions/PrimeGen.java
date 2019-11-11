package Functions;

public class PrimeGen {
    public String generatePrimes(double num) {
        String ans = "";
        boolean[] primes = new boolean[(int)num+2];
        for (int i = 0; i < num; i++) {
            primes[i] = true;
        }
        for(int i=2; i*i < num+1; i++) {
            if(primes[i] == true) {
                for(int j = i*i; j <= num; j += i) {
                    primes[j] = false;
                }
            }
        }
        for(int i = 2; i < num+2; i++) {
            if(primes[i] == true) {
                ans = ans + ", " + i;
            }
        }
        return ans;
    }
}
