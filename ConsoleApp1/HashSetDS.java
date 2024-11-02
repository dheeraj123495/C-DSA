import java.util.HashSet;
import java.util.Iterator;

public class HashSetDS {
    public static void main(String[] args){
        HashSet<Integer> hashList = new HashSet<Integer>();
        hashList.add(1);
        hashList.add(2);
        hashList.add(3);
        hashList.add(4);
        System.out.println(hashList);
        if (hashList.contains(2)){
            System.out.println("List contains value 2");
        }
        hashList.remove(4);
        System.out.println("After removing 4 : " + hashList);

        System.out.println("Printing using iterator : ");
        Iterator<Integer> iterator = hashList.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
    }
}
