import java.util.*;

public class towerOfHanoi {
    public static void towerOfHanoiMoves(int n, String src, String helper, String dest) {
        if (n == 1) { // Base case
            System.out.println("Transfer disk " + n + " from " + src + " to " + dest);
            return;
        }
        towerOfHanoiMoves (n-1, src, dest, helper); // Step 1
        System.out.println("Transfer disk " + n + " from " + src + " to " + dest); // Step 2
        towerOfHanoiMoves (n-1, helper, src, dest); // Step 3
    }
    static int numberOfMoves(int n, String src, String helper, String dest){
        if(n==1){
            return 1;
        }
        return numberOfMoves(n-1, src, dest, helper) + 1 + numberOfMoves(n-1, helper, src, dest);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();
        System.out.println();
        towerOfHanoiMoves (n, "A", "B", "C"); 
        System.out.println();
        System.out.println("Number of moves: " + numberOfMoves(n, "A", "B", "C"));
    }
}
