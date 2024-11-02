
class deQ{
    private int[] arr;
    public int rare = -1;
    public int front = -1;
    private int maxSize;
    deQ(int size){
        this.arr = new int[size];
        this.rare = -1;
        this.front = -1;
        this.maxSize = size;
    }

    public void insertFront(int element){
        if(isFull()){
            System.out.printf("Queue is full");
        }
        else {
            if(front < 1){
                front = maxSize-1;
            }
            else {
                front = front-1;
            }
            arr[front] = element;
            System.out.println("Element inserted : " + element);
        }
    }

    public void insertRare(int element){
        if (isFull()){
            System.out.println("Queue is full");
        }
        else {
            if(front == -1){
                front = 0;
                rare = 0;
            }
            else if(rare == maxSize-1){
                rare = 0;
            }
            else {
                rare = rare + 1;
            }
            arr[rare] = element;
            System.out.println("Element inserted : " + element);
        }
    }

    public int deleteFront(){
        int element;
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else{
            element = arr[front];
            if (front == rare){
                front = rare = -1;
            }
            else if(front == maxSize-1){
                front = 0;
            }
            else {
                front  = front + 1;
            }
            System.out.println("Deleted element is : " + element );
            return element;
        }
    }
    public int deleteRare(){
        int element;
        if (isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        else {
            element = arr[rare];
            if(front == rare){
                front = rare = -1;
            }
            else if(rare == 0){
                rare = maxSize-1;
            }
            else {
                rare = rare-1;
            }
            System.out.println("Deleted element is : " + element);
            return element;
        }
    }
    public boolean isFull(){
        if(front == 0 && rare == maxSize-1){
            return true;
        }
        if(front == rare+1){
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
    public void getFrontElement(){
        if (isEmpty()){
            System.out.println("Queue is empty");
        }
        else {
            System.out.println("Front element is : " + arr[front]);
        }
    }
    public void getRareElement(){
        if(isEmpty()){
            System.out.println("Queue is empty");
        }
        else {
            System.out.println("Rare element is : " + arr[rare]);
        }
    }
    public void displayQueue(){
        for (int i = 0;i < maxSize;i++){
            System.out.print(arr[i]);
        }
        System.out.println("");
    }
}

public class DeQueue {
    public static void main(String[] args){
        deQ dq =  new deQ(5);
//        dq.insertRare(1);
//        dq.insertRare(2);
//        dq.insertRare(3);
//        dq.displayQueue();
//        dq.insertFront(4);
//        dq.displayQueue();
////        dq.deleteFront();
//        dq.displayQueue();
//        dq.getFrontElement();
//        dq.getRareElement();
        dq.insertFront(1);
        dq.displayQueue();
        System.out.println(dq.front + ", " + dq.rare);
    }
}
