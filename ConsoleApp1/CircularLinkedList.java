

public class CircularLinkedList {
    Node head;
   CircularLinkedList(){
       this.head = null;
   }
    class Node{
        int data;
        Node next;
        Node(int value){
            this.data = value;
            this.next = null;
        }
    }
    public void insertFirst(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            head.next = head;
            return;
        }
        Node curNode = head;
        while (curNode.next != head){
            curNode = curNode.next;
        }
        newNode.next = head;
        head = newNode;
        curNode.next = head;
    }
    public void insertLast(int value){
        Node newNode = new Node(value);
        if (head == null){
            head = newNode;
            head.next = head;
        }
        Node curNode = head;
        while (curNode.next != head){
            curNode = curNode.next;
        }
        newNode.next = head;
        curNode.next = newNode;
    }
    public void insertAtPos(int value,int pos){
        Node newNode = new Node(value);
        Node curNode = head;
        Node index = null;
        int counter = 1;
        while (counter < pos){
            index = curNode;
            curNode = curNode.next;
            counter++;
        }
        newNode.next = curNode;
        index.next = newNode;
    }
    public void displayList(){
        if (head == null){
            System.out.println("List is empty");
            return;
        }
        Node curNode = head;
        do{
            System.out.print(curNode.data);
            curNode = curNode.next;
            if (curNode != head){
                System.out.print(" --> ");
            }
        } while (curNode != head);
        System.out.println("");
    }
    public static void main(String[] args){
        CircularLinkedList cll = new CircularLinkedList();
        cll.insertLast(1);
        cll.insertLast(2);
        cll.insertLast(3);
        cll.insertLast(4);
        cll.displayList();
        cll.insertAtPos(5,5);
        cll.displayList();
    }
}
