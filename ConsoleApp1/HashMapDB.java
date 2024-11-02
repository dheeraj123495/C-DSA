import java.util.HashMap;
import java.util.Set;

public class HashMapDB {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Hubli",100);
        hashMap.put("Dharwad",200);
        hashMap.put("Gadag",300);
        hashMap.put("Mysore",400);

        System.out.println(hashMap);

        System.out.println(hashMap.containsKey("Hubli"));

        Set<String> key = hashMap.keySet();
        for (String setKey :key){
            System.out.println(setKey + " - " + hashMap.get(setKey));
        }
        System.out.println(key);
    }
}
