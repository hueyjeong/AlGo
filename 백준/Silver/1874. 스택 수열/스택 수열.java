import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        List<Character> outputs = new ArrayList<>(n);

        int cursor = 0;
        int j = 1;
        while (cursor < n) {
            if (stack.isEmpty()) {
                stack.push(j++);
                outputs.add('+');
            }
            int pop = stack.pop();
            if(pop == inputs[cursor]) {
                outputs.add('-');
                cursor++;
            } else {
                stack.push(pop);
                stack.push(j++);
                if (j > n + 1) {
                    bw.write("NO\n");
                    outputs.clear();
                    break;
                }
                outputs.add('+');
            }
        }

        for (int i = 0; i < outputs.size(); i++) {
            bw.write(outputs.get(i) + "\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }
}