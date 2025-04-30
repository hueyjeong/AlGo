import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        long x = 0;
        boolean isPlus = true;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length() > 0) {
                    long y = Long.parseLong(sb.toString());
                    if (isPlus) {
                        x += y;
                    } else {
                        x -= y;
                    }
                    sb.setLength(0);
                }
                if (c == '-') {
                    isPlus = false;
                }
            }
        }
        if (isPlus) {
            x += Long.parseLong(sb.toString());
        } else {
            x -= Long.parseLong(sb.toString());
        }
        System.out.println(x);
    }

}