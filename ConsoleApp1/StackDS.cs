
class StackDS{
    int maxSize;
    int top;
    int[] arr;
    public StackDS(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.top = -1;
    }
    public void Push(int val){
        if(top == arr.Length-1){
            Console.WriteLine("Stack is full");
            return;
        }
        top = top + 1;
        arr[top] = val;
        Console.WriteLine("Value added to Stack : " + val);
    }
    public void Pop(){
        if(top == -1){
            Console.WriteLine("Stack is empty");
            return;
        }
        int val = arr[top];
        top = top - 1;
        Console.WriteLine("Deleted from stack : " + val);
    }

    public void Search(int val){
        if(top == -1){
            Console.WriteLine("Stack is empty, and search element is not present here");
            return;
        }
        for(int i = 0; i <= top; i++){
            if(val == arr[i]){
                Console.WriteLine("Element {0} present at position {1}", val, i + 1);
                return;
            }
        }
        Console.WriteLine(val + " element not found");
    }
    public void Display(){
        if(top == -1){
            Console.WriteLine("Stack is empty");
            return;
        }
        for(int i = 0; i <= top; i++){
            Console.Write(arr[i] + " ");
        }
        Console.WriteLine("");
    }
}