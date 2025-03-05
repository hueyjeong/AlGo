import java.io.*;
import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        PriorityQueue<Element> minQueue = new PriorityQueue<>(Comparator.comparing(Element::getValue));
        PriorityQueue<Element> maxQueue = new PriorityQueue<>(Comparator.comparing(Element::getValue).reversed());
        List<Element> elements = new ArrayList<>();

        Map<String, Function<Integer, Integer>> funcs = new HashMap<>();
        funcs.put("I", (Integer v) -> {
            Element el = new Element(v);
            elements.add(el);
            minQueue.add(el);
            maxQueue.add(el);
            return 0;
        });
        funcs.put("D", (Integer v) -> {
            if (v == 1) {
                if (maxQueue.isEmpty())
                    return -1;
                Element el = maxQueue.remove();
                while (!maxQueue.isEmpty() && el.isRemoved()) {
                    el = maxQueue.remove();
                }
                el.setRemoved(true);
            } else {
                if (minQueue.isEmpty())
                    return -1;
                Element el = minQueue.remove();
                while (!minQueue.isEmpty() && el.isRemoved()) {
                    el = minQueue.remove();
                }
                el.setRemoved(true);
            }
            return 0;
        });

        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());

            minQueue.clear();
            maxQueue.clear();
            elements.clear();

            for (int i = 0; i < k; i++) {
                StringTokenizer tok = new StringTokenizer(br.readLine());
                String command = tok.nextToken();
                int n = Integer.parseInt(tok.nextToken());
                funcs.get(command).apply(n);
            }
            elements.sort(Comparator.comparing(Element::getValue));

            Element min = null;
            for (Element element : elements) {
                if (!element.isRemoved()) {
                    min = element;
                    break;
                }
            }
            Element max = null;
            for (int i = elements.size() - 1; i >= 0; i--) {
                Element element = elements.get(i);
                if (!element.isRemoved()) {
                    max = element;
                    break;
                }
            }
            if (min == null || max == null) {
                System.out.println("EMPTY");
            } else {
                System.out.println(max.getValue() + " " + min.getValue());
            }
        }
    }

    static class Element {
        public int value;
        public boolean isRemoved;

        public Element(int value) {
            this.value = value;
            isRemoved = false;
        }

        public boolean isRemoved() {
            return isRemoved;
        }

        public void setRemoved(boolean removed) {
            isRemoved = removed;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
}