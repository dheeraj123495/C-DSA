import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
public class Lists {
    public static void main(String[] args){
        List<String> l1 = new ArrayList<String>();
        l1.add("Dsp");
        l1.add("Hubli");
        l1.add("KLE");
        l1.add("Bang");
        System.out.println(l1);
        String[] arr = new String[l1.size()];
        l1.toArray(arr);
        System.out.println(Arrays.toString(arr));

        ArrayList<String> languages = new ArrayList<>();
        languages.add("Java");
        languages.add("Python");
        languages.add("Swift");
        System.out.println("ArrayList: " + languages);

        // get the element from the arraylist
        String str = languages.get(1);
        System.out.print("Element at index 1: " + str);

        //change the element of the arraylist
        languages.set(1,"DSP");
        System.out.println("Modified arraylist : " + languages);

        languages.add(1,"C Lang");
        System.out.println("Added new element : " + languages);

        //sort the arraylist
        languages.sort(Comparator.naturalOrder());
        System.out.println("Sorted list :  " + languages);

        //convert to string
        String stringList = languages.toString();
        System.out.println("String value : " + stringList);
    }
}
