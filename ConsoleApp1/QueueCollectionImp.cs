class QueueCollectionImp{
    Queue<int> qu = new Queue<int>();

    public void Enqueue(int val){
        qu.Enqueue(val);
        Console.WriteLine("Value Added {0}", val);
    }

    public void Dequeue(){
        if(qu.Count == 0){
            Console.WriteLine("Queue is empty");
        }
        int val = qu.Dequeue();
        Console.WriteLine("Value deleted {0}", val);
    }

    public void Display(){
        if(qu.Count == 0){
            Console.WriteLine("Queue is empty");
            return;
        }else{
            Console.WriteLine("Queue elements are : ");
            foreach(int val in qu){
                Console.WriteLine(val);
            }
        }
    }
    public void Peek(){
        int val = qu.Peek();
        Console.WriteLine("Peek element is {0}", val);
    }
}