using System.Collections.Generic;
using System.Linq;

class StackCollectionImp{
    Stack<int> cars = new Stack<int>();
    public void Push(int val){
        cars.Push(val);
        Console.WriteLine("Value added : " + val);
    }
    public void Pop()
    {
        if(cars.Count == 0){
            Console.WriteLine("Stack is empty");
            return;
        }
        int val = cars.Pop();
        Console.WriteLine("Value Removed : " + val);
    }
    public void Peek(){
        if(cars.Count == 0){
            Console.WriteLine("Stack is empty");
            return;
        }
        int val = cars.Peek();
        Console.WriteLine("Top value : " + val);
    }

    public void Contain(int val){
        Console.WriteLine(cars.Contains(val) ? "Stack contains : " + val : "Stack does not contain : " + val);
    }

    public void ClearStack(){
        cars.Clear();
        Console.WriteLine("Stack cleared");
    }

    public void Display(){
        if(cars.Count == 0){
            Console.WriteLine("Stack is empty");
            return;
        }else{

            //Print in LIFO mode
            // foreach (var item in cars)
            // {
            //     Console.Write(item + " ");
            // } 

            //Print in FILO mode
            foreach (var item in cars.Reverse())
            {
                Console.Write(item + " ");
            }
            Console.WriteLine("");
        }
    }
}