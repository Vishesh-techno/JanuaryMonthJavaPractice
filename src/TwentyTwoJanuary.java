import java.util.Stack;

public class TwentyTwoJanuary {
    public static boolean validParanthesis(String bracket) {
        Stack<Character> s = new Stack<>();

        for (char c : bracket.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                s.push(c);
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                char top = s.pop();
                if ((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(validParanthesis("{{(([[){}]]"));
    }
}
