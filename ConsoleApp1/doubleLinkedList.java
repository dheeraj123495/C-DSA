

public class doubleLinkedList {
    static Node head;
    class Node{
        int data;
        Node prev;
        Node next;
        Node(int value){
            this.data = value;
            this.prev = null;
            this.next = null;
        }
    }
    public void addFirst(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            System.out.println("Element inserted beginning");
        }
    }
    public void addLast(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
        }else {
            Node curNode = head;
            while (curNode.next != null){
                curNode = curNode.next;
            }
            curNode.next = newNode;
        }
    }
    public void addAtPosition(int pos,int value){
        Node newNode = new Node(value);
        if (pos == 1){
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        Node curNode = head;
        Node index = null;
        int counter = 1;
        while (curNode!=null && counter < pos){
            index = curNode;
            curNode = curNode.next;
            counter++;
        }
        if (curNode == null){
            System.out.println("Out of bound");
            return;
        }
        newNode.next = curNode;
        newNode.prev = index;
        index.next = newNode;
        curNode.prev = newNode;
    }
    public void deleteFirst(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        head = head.next;
        System.out.println("First element deleted");
    }
    public void deleteLast(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        Node curNode = head;
        Node index = null;
        while (curNode.next != null){
            index = curNode;
            curNode = curNode.next;
        }
        index.next = null;
        System.out.println("Last element deleted");
    }
    public void deletePosition(int pos){
        if (head == null){
            System.out.println("List is already empty");
            return;
        }
        if (pos == 1){
            head = head.next;
            head.prev = null;
            return;
        }
        Node curNode = head;
        Node index = null;
        int counter = 1;
        while (curNode != null && counter < pos){
            index = curNode;
            curNode = curNode.next;
            counter++;
        }
        if (curNode == null){
            System.out.println("out of bond");
            return;
        }
        index.next = curNode.next;
    }
    public void printList(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null){
            System.out.print(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null){
                System.out.print(" --> ");
            }
        }
        System.out.println("");
    }
    public static void main(String[] args){
        doubleLinkedList dll = new doubleLinkedList();
        dll.addFirst(2);
        dll.addFirst(1);
        dll.printList();
        dll.addLast(3);
        dll.addLast(4);
        dll.printList();
        dll.deleteLast();
        dll.printList();
        dll.addLast(6);
        dll.printList();
        dll.addAtPosition(4,9);
        dll.printList();
        dll.deletePosition(5);
        dll.printList();
    }
}
