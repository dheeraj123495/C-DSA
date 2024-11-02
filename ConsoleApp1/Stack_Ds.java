import java.util.Stack;
import java.util.Scanner;

public class Stack_Ds {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> st = new Stack<>();
        st.push("Dheeraj");
        st.push("Pawar");
        st.push("Hubli");
        st.push("KLE");
        st.push("Bang");
        st.push("Bangerferf");

        //Size of stack
        System.out.println(st.size());

        //Pop the element
        System.out.println(st.pop());
        System.out.println(st.size());

        //Get the top element
        System.out.println(st.peek());

        //Check is empty
        System.out.println(st.empty());

        //Search element
        System.out.println(st.empty());

        String str = sc.nextLine();
        System.out.println(str);
    }
}
