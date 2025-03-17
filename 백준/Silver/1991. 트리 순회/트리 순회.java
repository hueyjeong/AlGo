import java.io.*;
import java.util.*;

public class Main {
    private static final Map<Character, Character[]> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            char parent = str.charAt(0);
            char left = str.charAt(2);
            char right = str.charAt(4);
            tree.put(parent, new Character[]{left, right});
        }
        bw.write(pre('A') + "\n");
        bw.write(in('A') + "\n");
        bw.write(post('A') + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    private static String pre(Character parent) {
        if (!tree.containsKey(parent))
            return "";
        Character[] children = tree.get(parent);
        String str = parent.toString();
        if (!children[0].equals('.')) {
            str += pre(children[0]);
        }
        if (!children[1].equals('.')) {
            str += pre(children[1]);
        }
        return str;
    }
    private static String in(Character parent) {
        if (!tree.containsKey(parent))
            return "";
        Character[] children = tree.get(parent);
        String str = "";
        if (!children[0].equals('.')) {
            str += in(children[0]);
        }
        str += parent;
        if (!children[1].equals('.')) {
            str += in(children[1]);
        }
        return str;
    }
    private static String post(Character parent) {
        if (!tree.containsKey(parent))
            return "";
        Character[] children = tree.get(parent);
        String str = "";
        if (!children[0].equals('.')) {
            str += post(children[0]);
        }
        if (!children[1].equals('.')) {
            str += post(children[1]);
        }
        str += parent;
        return str;
    }

}