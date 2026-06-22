import java.util.*;

public class numberOfCombinations(nCk)
{   
    static int combination(int n, int k){
        if(n==k || k==0){
            return 1;
        }
        return combination(n-1, k-1) + combination(n-1, k);
    }
	public static void main(String[] args) {
	  Scanner sc = new Scanner(System.in);
		System.out.print("Enter n: ");
		int n=sc.nextInt();
		System.out.print("Enter k: ");
		int k=sc.nextInt();
		System.out.println();
		System.out.println("Number of Combinations: " + combination(n,k));
	}
}
