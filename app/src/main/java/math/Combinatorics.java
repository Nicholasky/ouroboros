package math;

public class Combinatorics {

    // Decode an arrangement id to a unique arrangement of numChoices indistinguishable objects  
    public static int[] decodeArrangement(int id, int numChoices){
        int[] values = new int[4];
        int remainder = id;

        for(int i = 0; i < 4; i++){
            int k = 4 - i;  // k: index of array
            int n = k - 1;  // n: highest value that fulfills nCr(n, k) <= rem
            
            while(nCr(n+1, k) <= remainder){
                n++;
            }

            values[i] = n;
            remainder -= nCr(n, k);
        }


        return values;
    }

    // calc number of combinations; n choose k
    public static int nCr(int n, int k) {
        if (k < 0 || k > n) return 0;
        if (k == 0 || k == n) return 1;

        if (k > n / 2) k = n - k;

        long result = 1;
        for (int i = 1; i <= k; i++) {
            result = result * (n - i + 1) / i;
        }
        return (int) result;
    }
}
