import java.util.Arrays;
import java.util.Stack;

class Stack1{
    private int[] arr;
    private int maxSize;
    private int top = -1;

    Stack1(int size){
        this.arr = new int[size];
        this.maxSize = size;
        this.top = -1;
    }

    public void push(int element){
        if(isFull()){
            System.out.println("Stack is full");
        }
        else {
            arr[++top]=element;
            System.out.println("Pushed " + element + " to the stack.");
        }
    }
    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        else {
            int val = arr[top];
            arr[top--] = 0;
            System.out.println("Popped " + val + " value from the stack");
            return val;
        }
    }
    public boolean isFull(){
        return (top==maxSize-1);
    }
    public boolean isEmpty(){
        return (top == -1);
    }
    public void displayItem(){
//        System.out.println("Items are : " + Arrays.toString(arr));
//        System.out.println("Length is  : " + arr.length);
        for (int i = 0;i<=top;i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }
    public boolean searchElement(int element){
        if (isEmpty()){
            return false;
        }
        else {
            for (int i = 0;i<=top;i++){
                if(arr[i] == element){
                    return true;
                }
            }
        }
        return false;
    }
}

public class stackCompleteImplementation {
    public static void main(String[] args){
        Stack1 st = new Stack1(5);
        st.isEmpty();
        st.push(1);
        st.push(2);
        st.push(3);
        st.pop();
        st.displayItem();
        System.out.println("Search for 2 : " + st.searchElement(2));
        System.out.println("Search for 5 : " + st.searchElement(5));
    }
}
