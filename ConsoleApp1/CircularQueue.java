class CircularQ{
    private int[] arr;
    private int maxSize;
    private int front = -1;
    private int rear = -1;
    CircularQ(int size){
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
        this.maxSize = size;
    }

    public void enqueue(int element){
        if (isFull()){
            System.out.println("Queue is full");
        }
        else {
            if(front == -1) front = 0;
            rear = (rear + 1) % maxSize;
            arr[rear] = element;
            System.out.println("Inserted : " + element);
        }
    }
    public int dequque(){
        int element;
        if(isEmpty()){
            System.out.printf("Queue is empty");
            return -1;
        }
        else {
            element = arr[front];
            if (front == rear){
                front = -1;
                rear = -1;
            }
            else {
                front = (front+1) % maxSize;
            }
            System.out.println("Deleted element is : " + element);
            return element;
        }
    }
    public void display(){
        System.out.printf("Elements are : ");
        for (int i = front;i<=rear;i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }
    public boolean isFull(){
        if(front == 0 && rear == maxSize-1)
        {
            return true;
        }
        if (front == rear+1){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(front == -1){
            return true;
        }
        else {
            return false;
        }
    }
}

public class CircularQueue {
    public static void main(String[] args){
        CircularQ cq = new CircularQ(5);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);
        cq.enqueue(5);
        cq.enqueue(6);
       cq.display();
       cq.dequque();
       cq.display();
       cq.enqueue(6);
       cq.display();
    }
}
