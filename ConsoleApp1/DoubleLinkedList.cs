class Node2<T>{
    public T Value;
    public Node2<T>? prev;
    public Node2<T>? next;
    public Node2(T value){
        this.Value = value;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList<T>{
    Node2<T>? head = null;
    Node2<T>? tail = null;
    public void AddFirst(T value){
        Node2<T> newNode = new Node2<T>(value);
        if (head == null){
            head = newNode;
            tail = head;
            Console.WriteLine("Inserted element at first : " + value);
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        Console.WriteLine("Inserted element at first : " + value);
    }

    public void AddLast(T value){
        Node2<T> newNode = new Node2<T>(value);
        if(head == null){
            head = newNode;
            Console.WriteLine("Inserted element at last : " + value);
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        Console.WriteLine("Inserted element at last : " + value);
    }

    public void DeleteFirst(){
        if(head == null){
            Console.WriteLine("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            Console.WriteLine("Element deleted from first");
            return;
        }
        head = head.next;
        Console.WriteLine("Element deleted from first");
    }

    public void DeleteLast(){
        if(head == null){
            Console.WriteLine("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            Console.WriteLine("Element deleted from last");
            return;
        }
        tail = tail.prev;
        if(tail != null){
            tail.next = null;
        }
        Console.WriteLine("ELement deleted from last");
    }
}