import java.util.*;

public class fastTrackGate
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> boarded = new ArrayList<>();
        ArrayList<Integer> quit = new ArrayList<>();

        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++)
        {
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            
            switch(parts[0]){
                case "VIP":
                    int vip_id = Integer.parseInt(parts[1]);
                    dq.offerFirst(vip_id);
                    break;
                case "REGULAR":
                    int reg_id = Integer.parseInt(parts[1]);
                    dq.offerLast(reg_id);
                    break;
                case "BOARD":
                    if(!dq.isEmpty()){
                        boarded.add(dq.pollFirst());
                        break;
                    }
                case "QUIT":
                    if(!dq.isEmpty()){
                        quit.add(dq.pollLast());
                        break;
                    }
            }
        }
        System.out.print("Boarded: ");
        for (int i=0; i<boarded.size(); i++){
            System.out.print(boarded.get(i) + " ");
        }
        System.out.print("Quit: ");
        for (int j=0; j<quit.size(); j++){
            System.out.print(quit.get(j) + " ");
        }
        System.out.print("Waiting: ");
        while (!dq.isEmpty()){
            System.out.print(dq.pollFirst() + " ");
        }
    }
}
