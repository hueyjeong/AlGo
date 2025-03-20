import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (!(input = br.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            if (input.charAt(input.length() - 1) != '.') {
                System.out.println("no");
                continue;
            }
//            input = input.replaceAll("[^()\\[\\]]+", "");
            boolean yes = true;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == ')') {
                    if (stack.isEmpty()) {
                        yes = false;
                        break;
                    }
                    if (stack.peek().equals('[')) {
                        yes = false;
                        break;
                    } else if (stack.peek().equals('(')) {
                        stack.pop();
                    }
                }
                if (ch == ']') {
                    if (stack.isEmpty()) {
                        yes = false;
                        break;
                    }
                    if (stack.peek().equals('(')) {
                        yes = false;
                        break;
                    } else if (stack.peek().equals('[')) {
                        stack.pop();
                    }
                }
                if (ch == '(' || ch == '[') {
                    stack.push(ch);
                }
            }
            if (!stack.isEmpty()) {
                yes = false;
            }
            System.out.println(yes ? "yes" : "no");
        }
    }
}
