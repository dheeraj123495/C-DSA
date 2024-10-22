
class Node<T>{
    public T data;
    public Node<T>? next;
    public Node(T data){
        this.data = data;
        this.next = null;
    }
}
class SingleLinkedList<T>
{
    public Node<T>? head;

    public void AddEnd(T val){
        Node<T> newNode = new Node<T>(val);
        if(head == null){
            head = newNode;
            Console.WriteLine("Element added at end : " + val);
            return;
        }
        Node<T> curNode = head;
        while(curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
        Console.WriteLine("Element added at end : " + val);
    }

    public void RemoveEnd(){
        if(head == null){
            Console.WriteLine("List is empty");
            return;
        }
        if(head.next == null){
            T val1 = head.data;
            head = null;
            Console.WriteLine("Element removed from last : " + val1);
            return;
        }
        Node<T> curNode = head;
        Node<T> prevNode = null;
        while(curNode.next != null){
            prevNode = curNode;
            curNode = curNode.next;
        }
        T val = curNode.data;
        prevNode.next = null;
        Console.WriteLine("Element removed from last : " + val);
    }

    public void AddStart(T val){
        Node<T> newNode = new Node<T>(val);
        if(head == null){
            head = newNode;
            Console.WriteLine("Element added at start : " + val);
            return;
        }
        newNode.next = head;
        head = newNode;
        Console.WriteLine("Element added at start: " + val);
    }

    public void RemoveStart(){
        if(head == null){
            Console.WriteLine("List is empty");
            return;
        }
        if(head.next == null){
            T val1 = head.data;
            head = null;
            Console.WriteLine("Element deleted at start : " + val1);
            return;
        }
        T val = head.data;
        head = head.next;
        Console.WriteLine("Element deleted at start: " + val);
    }

    public void Display(){
        if(head == null){
            Console.Write("List is empty");
            return;
        }
        Node<T> curNode = head;
        while(curNode != null){
            Console.Write(curNode.data + " ");
            if(curNode.next != null){
                Console.Write("=> ");
            }
            curNode = curNode.next;
        }
    }
}