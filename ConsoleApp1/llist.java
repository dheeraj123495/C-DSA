public class llist {
    Node head;
    class Node{
        String data;
        Node next;
        Node(String data){
            this.data = data;
            this.next = null;
        }
    }
    public void addFirst(String value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }
    public void addLast(String value){
        Node newNode = new Node(value);
        if(head == null){
            head = newNode;
            return;
        }
        Node curNode = head;
        while (curNode.next != null){
            curNode = curNode.next;
        }
        curNode.next = newNode;
    }

    public void addAtPosition(int pos,String value){
        Node newNode = new Node(value);
        if (pos == 0){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node currentNode = head;
        int count = 1;
        while (count < pos-1){
            currentNode = currentNode.next;
            count++;
        }
        if (currentNode == null){
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;
    }
    public void deleteLast(){
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node lastNode = head.next;
        Node lastSecond = head;
        while (lastNode.next != null){
            lastSecond = lastNode;
            lastNode = lastNode.next;
        }
        lastSecond.next = null;
        System.out.println("Last Node Deleted");
    }
    public void deleteFirst(){
        if(head == null){
            System.out.println("LinkedList is Empty");
            return;
        }
        head = head.next;
        System.out.println("First Element deleted");
    }
//    public void deleteSpecificPos(int pos){
//        int counter = 3;
//        if (pos == 1){
//            head = head.next;
//            System.out.println("Deleted element at position : " + pos);
//            return;
//        }
//        if (pos == 2){
//            head.next = head.next.next;
//            System.out.println("Deleted element at position : " + pos);
//            return;
//        }
//        Node firstNode = head;
//        Node secondNode = head.next.next;
//        while (counter < pos + 1){
//            firstNode = firstNode.next;
//            secondNode = secondNode.next;
//            counter++;
//        }
//        firstNode.next = secondNode;
//        System.out.println("Deleted element at position : " + pos);
//    }
    public void deleteSpecificPos(int pos){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        if (pos == 1){
            head = head.next;
            System.out.println("Deleted element at position : " + pos);
            return;
        }
        Node current = head;
        Node previous = null;
        int count = 1;
        while (current != null && count < pos){
            previous = current;
            current = current.next;
            count++;
        }
        if (current == null){
            System.out.println("Position outbound");
            return;
        }
        previous.next = current.next;
    }
    public void print(){
        Node curNode = head;
        if (head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        else {
            while (curNode != null){
                System.out.print(curNode.data);
                curNode = curNode.next;
                if (curNode != null){
                    System.out.print(" --> ");
                }
            }
            System.out.println("");
        }
    }
    public void searchElement(String value){
        Node curNode = head;
        int position = 1;
        while (curNode != null){
            if (curNode.data == value){
                System.out.println("Element " + value + " found at position : " + position);
                return;
            }
            curNode = curNode.next;
            position++;
        }
        if (curNode == null){
            System.out.println("No element found");
            return;
        }
    }
    public static void main(String[] args){
        llist ll = new llist();
        ll.addLast("A");
        ll.addLast("B");
        ll.addLast("C");
        ll.addLast("D");
        ll.print();
        ll.searchElement("X");
        ll.addAtPosition(3,"Z");
        ll.print();
        ll.addAtPosition(6,"Q");
        ll.print();
    }
}
