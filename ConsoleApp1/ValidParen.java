import java.util.Stack;

public class ValidParen {
    public static boolean isValidParen(String st){
        Stack<Character> stack = new Stack<>();
        if(st.length() <=1){
            return false;
        }
        for (int i = 0; i<st.toCharArray().length;i++){
            Character ch = st.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                else {
                    Character top = stack.pop();
                    if ((ch == ')' && top != '(') || (ch == '}' && top != '{') || (ch == ']' && top != '[')){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args){
        String st = "[[";
        boolean isValid = isValidParen(st);
        System.out.println(isValid);
    }
}
