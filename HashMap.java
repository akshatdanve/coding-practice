import java.util.*;

class Node{
    String key;
    int value;
    Node next;
    
    Node(String key, int value){
        this.key=key;
        this.value=value;
        this.next=null;
    }
}

class HashMap{
    int size;
    int capacity;
    Node[] buckets;
    
    int hashFunction(String key){
        int h=key.hashCode();
        int hash = Math.abs(h)%capacity;
        return hash;
    }
   
    HashMap(){
        capacity=16;
        size=0;
        buckets=new Node[capacity];
    }
        
        void put(String key, int value){
            int index=hashFunction(key);
            //if the index of that bucket is empty
            if(buckets[index]==null){
                buckets[index]=new Node(key, value);
                size++;
            }
            //updating the value
            Node curr=buckets[index];
            while(curr!=null){
                if(curr.key==key){
                    curr.value=value;
                    return;
                }
                curr=curr.next;
            }
            //if an element already exists at the index(chaining)
            curr=buckets[index];
            while(curr!=null){
                curr=curr.next;
            }
            curr.next=new Node(key,value);
            size++;
        }
        
        int get(String key){
            int index=hashFunction(key);
            Node curr=buckets[index];
            while(curr!=null){
                if(curr.key.equals(key)){
                    return curr.value;
                }
                curr=curr.next;
            }
            return -1;
        }
        
        int remove(String key){
            int index=hashFunction(key);
            Node prev=null;
            Node curr=buckets[index];
            
            while(curr!=null){
                if(curr.key==key){
                    if(prev==null){
                        buckets[index]=curr.next;
                        size--;
                        return curr.value;
                    }
                    else{
                        prev.next=curr.next;
                        size--;
                        return curr.value;
                    }
                }
                prev=curr;
                curr=curr.next;
            }
            return -1;
        }
        
        boolean containsKey(String key){
            int index=hashFunction(key);
            Node curr=buckets[index];
            while(curr!=null){
                if(curr.key==key){
                    return true;
                }
            }
            return false;
        }
    
}



public class Main
{
	public static void main(String[] args) {
		HashMap map = new HashMap();
		map.put("Akshat@oksbi", 50); //insert at empty index
		System.out.println(map.containsKey("Akshat@oksbi"));
		System.out.println(map.get("Akshat@oksbi"));
		map.put("Akshat@oksbi", 100); //update value
		System.out.println(map.containsKey("Akshat@oksbi")); //check if key is present
		System.out.println(map.get("Akshat@oksbi")); //retrieve the value associated with key
		map.remove("Akshat@oksbi"); //remove key
		System.out.println(map.containsKey("Akshat@oksbi"));
		System.out.println(map.get("Akshat@oksbi"));
		
	}
}


/**
 Sample Output-
true
50
true
100
false
-1
**/
