import java.util.*;

class Node{
    String name;
    Node next;
    
    Node(String name){
        this.name=name;
        this.next=null;
    }
}
public class Main
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		sc.nextLine();
		String[] horses = sc.nextLine().split(" ");
		
		Node head = new Node(horses[0]);
		Node tail = head;
		for(int k=1; k<horses.length; k++){
		    Node newNode = new Node(horses[k]);
		    tail.next=newNode;
		    tail=newNode;
		}
		tail.next=head;
		Node cur = head;
		
		int n = sc.nextInt();
		sc.nextLine();
		ArrayList<String> ans = new ArrayList<>(); 
		for (int i=0; i<n; i++){
		    String command = sc.nextLine();
		    String[] parts = command.split(" ");
		    
		    switch (parts[0]){
		        case "CALL":
		            ans.add(cur.name);
		            cur = cur.next;
		            break;
		        case "ROTATE":
		            int id = Integer.parseInt(parts[1]);
		            for (int j=0; j<id; j++){
		                cur=cur.next;
		            }
		            break;
		    }
		}
		System.out.println();
		System.out.print("Called: ");
		for(int y=0; y<ans.size(); y++){
		    System.out.print(ans.get(y) + " ");
		}
		System.out.print("\nCurrent: " + cur.name);
	}
}
