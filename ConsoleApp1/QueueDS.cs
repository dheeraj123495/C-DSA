
class QueueDS{
    int[] arr;
    int maxSize;
    int start = -1;
    int end = -1;
    public QueueDS(int maxSize){
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    public void Enqueue(int val){
        if(end == arr.Length-1){
            Console.WriteLine("Queue is full");
            return;
        }
        if(start == -1){
            start = 0;
        }
        end++;
        arr[end] = val;
        Console.WriteLine("Value added : " + val);
    }
    
    public void Dequeue(){
        if(start == -1){
            Console.WriteLine("Queue is empty");
            return;
        }
        int val = arr[start];
        if(start == end){
            start = -1;
            end = -1;
        }else{
            start++;
        }
        Console.WriteLine("Value deleted : " + val);
    }

    public void Display(){
        if(start == -1){
            Console.WriteLine("Queue is empty");
            return;
        }
        else{
            Console.WriteLine("The queue elements are: ");
            for(int i = start;i <= end;i++){
                Console.WriteLine(arr[i]);
            }
        }
    }
}