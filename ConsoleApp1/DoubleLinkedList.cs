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

    public void InsertAtPosition(int position,T value) {
        Node2<T> newNode = new Node2<T>(value);
        if(head == null){
            head = newNode;
            tail = newNode; ;    
            Console.WriteLine("List was empty, element added at 1st position");
            return;
        }
        if(position == 1){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            Console.WriteLine("Element added at pos: " + position);
            return;
        }
        Node2<T> currentNode = head;
        int count = 1;
        while(count < position - 1 && currentNode != null){
            currentNode = currentNode.next;
            count++;
        }
        if(currentNode == null){
            Console.WriteLine("Position out of range");
            return;
        }
        if(currentNode.next == null){
            currentNode.next = newNode;
            newNode.prev = currentNode;
            tail = newNode;
            Console.WriteLine("Element added at position " + position);
            return;
        }
        newNode.next = currentNode.next;
        newNode.prev = currentNode;
        currentNode.next.prev = newNode;
        currentNode.next = newNode;
        if(currentNode == tail){
            tail = newNode;
        }
        Console.WriteLine("Element added at position " + position);
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

    public void DeleteAtPosition(int position){
        if(head == null){
            Console.WriteLine("List is empty");
            return;
        }
        if(head.next == null){
            head = null;
            tail = null;
            Console.WriteLine("Only one element remaining, that is deleted");
            return;
        }
        if(position == 1){
            head = head.next;
            head.prev = null;
            Console.WriteLine("Element deleted at position : " + position);
            return;
        }
        Node2<T> curNode = head;
        int count = 0;
        while(count < position && curNode != null){
            curNode = curNode.next;
            count++;
        }
        if(curNode == null){
            Console.WriteLine("Out of bound");
            return;
        }
        if(curNode == tail || curNode.next == null){
            tail = curNode.prev;
            tail.next = null;
            Console.WriteLine("Element deleted at position : " + position);
            return;
        }
        curNode.prev.next = curNode.next;
        curNode.next.prev = curNode.prev;
        Console.WriteLine("Element deleted at position : " + position);
    }
}