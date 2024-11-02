class Queue{
    private int[] arr;
    private int front = -1;
    private int rare = -1;
    private int maxCapacity;
    Queue(int size){
        this.maxCapacity = size;
        this.arr = new int[size];
        this.rare = -1;
        this.front = -1;
    }
    public void enqueue(int element){
        if (isFull()){
            System.out.println("Queue is full");
        }else {
            if(front == -1)
            {
                front = 0;
            }
            rare++;
            arr[rare] = element;
        }
    }

    public void dequeue(){
        int element = 0;
        if (isEmpty()){
            System.out.println("Queue is empty");
            return;
        }
        else {
            element = arr[front];
            if(front >= rare){
                front = -1;
                rare = -1;
            }
            {
                front++;
            }
            System.out.println(element + " is deleted");
        }
    }
    public int peek(){
        if (isEmpty()){
            System.out.printf("Queue is empty");
            return -1;
        }
        else {
            return arr[front];
        }
    }
    public boolean isFull(){
        if(rare == maxCapacity-1){
            return true;
        }
        else {
            return false;
        }
    }

    public void display(){
        for (int i = front;i<=rare;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
    }
    public boolean isEmpty(){
        if (front == -1){
            return true;
        }
        else {
            return false;
        }
    }
}

public class Queue_DS {
    public static void main(String[] args){
        Queue q = new Queue(5);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.display();
        q.dequeue();
        q.display();
        q.enqueue(10);
        q.display();
        q.enqueue(69);
        q.display();
    }
}
