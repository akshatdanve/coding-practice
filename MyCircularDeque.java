class MyCircularDeque {
    int [] arr;
    int front;
    int rear;
    int capacity;
    int size;

    public MyCircularDeque(int k) {
        capacity=k;
        arr=new int[k];
        front=-1;
        rear=-1;
        size=0;
    }
    
    public boolean insertFront(int value) {
        if(size==capacity){
            return false;
        }
        if(size==0){
            front=0;
            rear=0;
            size=1;
            arr[front]=value;
            return true;
        }
        front=(front-1+capacity)%capacity;
        arr[front]=value;
        size+=1;
        return true;
        
    }
    
    public boolean insertLast(int value) {
        if(size==capacity){
            return false;
        }
        if(size==0){
            front=0;
            rear=0;
            size=1;
            arr[rear]=value;
            return true;
        }
        rear=(rear+1)%capacity;
        arr[rear]=value;
        size+=1;
        return true;
    }
    
    public boolean deleteFront() {
        if(size==0){
            return false;
        }
        if(size==1){
            front=-1;
            rear=-1;
            size=0;
            return true;
        }
        front=(front+1)%capacity;
        size-=1;
        return true;
    }
    
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        if(size==1){
            front=-1;
            rear=-1;
            size=0;
            return true;
        }
        rear=(rear-1+capacity)%capacity;
        size-=1;
        return true;
    }
    
    public int getFront() {
        if(size==0){
            return -1;
        }
        return arr[front];
    }
    
    public int getRear() {
        if(size==0){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isFull() {
        if(size==capacity){
            return true;
        }
        else{
            return false;
        }
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
