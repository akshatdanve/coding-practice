// Cart Total via HashMap Lookup
import java.util.HashMap;
import java.util.*;

class cartTotal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        HashMap<String,Integer> prices = new HashMap<>();
        for(int i=0; i<m; i++){
            String id = sc.next();
            int price = sc.nextInt();
            prices.put(id,price);
        }
        int total=0;
        int k = sc.nextInt();
        for (int i=0;i<k;i++){
            String id = sc.next();
            int qty = sc.nextInt();
            
            int price=prices.get(id);
            total=price*qty;
        }
        
        System.out.println("Cart Total:" + total);
    }
}
