import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            PrinterDocument[] items = new PrinterDocument[n];
            Queue<PrinterDocument> queue = new ArrayDeque<>(n);
            int cursor = 0;

            for (int i = 0; i < n; i++) {
                int priority = sc.nextInt();
                PrinterDocument item = new PrinterDocument(i, priority);
                items[cursor++] = item;
                queue.add(item);
            }

            Arrays.sort(items, Comparator.comparing(PrinterDocument::getPriority));

            int count = 0;

            while (!queue.isEmpty()) {
                PrinterDocument item = queue.remove();

                if (item.getPriority() < items[cursor - 1].getPriority()) {
                    queue.add(item);
                    continue;
                }
                count++;
                cursor--;

                if (item.getNumber() == m) {
                    break;
                }
            }

            System.out.println(count);
        }
    }

    static class PrinterDocument {
        private int number;
        private int priority;

        public PrinterDocument(int number, int priority) {
            this.number = number;
            this.priority = priority;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }
    }
}