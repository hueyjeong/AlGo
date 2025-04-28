import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputs = br.lines().map(Integer::parseInt).collect(Collectors.toList());
        Node root = new Node(inputs.get(0));
        for (int i = 1; i < inputs.size(); i++) {
            insert(root, inputs.get(i));
        }

        // post order traversal
        StringBuilder sb = postOrder(root, new StringBuilder());
        System.out.println(sb);
    }

    private static StringBuilder postOrder(Node root, StringBuilder stringBuilder) {
        if (root == null) {
            return stringBuilder;
        }
        postOrder(root.left, stringBuilder);
        postOrder(root.right, stringBuilder);
        stringBuilder.append(root.value).append("\n");
        return stringBuilder;
    }

    private static void insert(Node parent, Integer current) {
        if (parent.value > current) {
            if (parent.left == null) {
                parent.left = new Node(current);
            } else {
                insert(parent.left, current);
            }
        } else {
            if (parent.right == null) {
                parent.right = new Node(current);
            } else {
                insert(parent.right, current);
            }
        }
    }

    public static class Node {
        int value;
        Node left;
        Node right;
        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}