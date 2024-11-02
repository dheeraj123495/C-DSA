import java.util.Stack;

public class validParenthesis {
    public static boolean isValid(String st){
        Stack<Character> stack = new Stack<>();
        for (char c:st.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                else {
                    char top = stack.pop();
                    if((c == ')' && top!='(') || (c == '}' && top!='{') || (c   == ']' && top!='['))
                    {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String test1 = "{([])}";
        String test2 = "{[}]";
        String test3 = "({})";
        String test4 = "(]";
        String test5 = "()[]";
        System.out.println("is" + test1 + "valid?" + isValid(test1));
        System.out.println("is" + test2 + "valid?" + isValid(test2));
        System.out.println("is" + test3 + "valid?" + isValid(test3));
        System.out.println("is" + test4 + "valid?" + isValid(test4));
        System.out.println("is" + test5 + "valid?" + isValid(test5));
    }
}