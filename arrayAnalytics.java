// Array Analytics: Maximum Subarray + Equilibrium Index
import java.util.*;

public class arrayAnalytics {
    // This function contains a BUG. Find it and fix it.
    static long maxSubarraySum(long[] a) {
        long best = a[0], cur = a[0];
        for (int i = 1; i < a.length; i++) { 
            cur = Math.max(cur + a[i], a[i]); 
            best = Math.max(best, cur);
        }
        return best;
    }

    public static int equilibriumIndex(long[] a) {
        long totalSum = 0;
        long leftSum = 0;
        long rightSum=0;

       
        for (int i = 0; i < a.length; i++) {
            totalSum += a[i];
        }

       
        for (int i = 0; i < a.length; i++) {
           
            rightSum = totalSum - leftSum - a[i];

            if (leftSum == rightSum) {
                return i; 
            }

            leftSum += a[i]; 
        }

        return -1; 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        System.out.println("Max Subarray Sum: " + maxSubarraySum(a));
        System.out.println("Equilibrium Index: " + equilibriumIndex(a));
    }
}
