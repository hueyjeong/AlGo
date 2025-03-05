import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());

            MinHeap minQueue = new MinHeap(k);
            MaxHeap maxQueue = new MaxHeap(k);
            List<Element> elements = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer tok = new StringTokenizer(br.readLine());
                String command = tok.nextToken();
                int n = Integer.parseInt(tok.nextToken());

                if (command.equals("D")) {
                    if (n == 1) {
                        if (maxQueue.isEmpty())
                            continue;
                        Element el = maxQueue.remove();
                        while (!maxQueue.isEmpty() && el.isRemoved()) {
                            el = maxQueue.remove();
                        }
                        el.setRemoved(true);
                    } else {
                        if (minQueue.isEmpty())
                            continue;
                        Element el = minQueue.remove();
                        while (!minQueue.isEmpty() && el.isRemoved()) {
                            el = minQueue.remove();
                        }
                        el.setRemoved(true);
                    }
                } else {
                    Element el = new Element(n);
                    elements.add(el);
                    minQueue.add(el);
                    maxQueue.add(el);
                }
            }
            elements.sort(Comparator.comparing(Element::getValue));

            Element min = null;
            int z = 0;
            for (int i = 0; i < elements.size(); i++) {
                Element element = elements.get(i);
                if (!element.isRemoved()) {
                    min = element;
                    z = i;
                    break;
                }
            }
            Element max = null;
            for (int i = elements.size() - 1; i >= z; i--) {
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


    static class MinHeap {
        private Element[] tree;
        private int size;
        public MinHeap(int length) {
            tree = new Element[length];
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(Element value) {
            tree[size] = value;

            int current = size;
            size++;
            while (current > 0) {
                int parent = getParent(current);
                if (tree[parent].value > tree[current].value) {
                    swap(parent, current);
                    current = parent;
                } else {
                    break;
                }
            }
        }

        public Element remove() {
            Element value = tree[0];
            tree[0] = tree[--size];

            int current = 0;

            while (true) {
                int c1 = firstChild(current);
                int c2 = c1 + 1;

                int sc = current;
                if (c1 < size && tree[current].value > tree[c1].value) {
                    sc = c1;
                }
                if (c2 < size && tree[sc].value > tree[c2].value) {
                    sc = c2;
                }

                if (sc == current) {
                    break;
                }
                swap(current, sc);
                current = sc;
            }

            return value;
        }

        private int getParent(int idx) {
            return (idx - 1) / 2;
        }

        private void swap(int a, int b) {
            Element temp = tree[a];
            tree[a] = tree[b];
            tree[b] = temp;
        }

        private int firstChild(int idx) {
            return idx * 2 + 1;
        }

    }


    static class MaxHeap {
        private Element[] tree;
        private int size;
        public MaxHeap(int length) {
            tree = new Element[length];
            size = 0;
        }

        public int size() {
            return size;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void add(Element value) {
            tree[size] = value;

            int current = size;
            size++;
            while (current > 0) {
                int parent = getParent(current);
                if (tree[parent].value < tree[current].value) {
                    swap(parent, current);
                    current = parent;
                } else {
                    break;
                }
            }
        }

        public Element remove() {
            Element value = tree[0];
            tree[0] = tree[--size];

            int current = 0;

            while (true) {
                int c1 = firstChild(current);
                int c2 = c1 + 1;

                int sc = current;
                if (c1 < size && tree[current].value < tree[c1].value) {
                    sc = c1;
                }
                if (c2 < size && tree[sc].value < tree[c2].value) {
                    sc = c2;
                }

                if (sc == current) {
                    break;
                }
                swap(current, sc);
                current = sc;
            }

            return value;
        }

        private int getParent(int idx) {
            return (idx - 1) / 2;
        }

        private void swap(int a, int b) {
            Element temp = tree[a];
            tree[a] = tree[b];
            tree[b] = temp;
        }

        private int firstChild(int idx) {
            return idx * 2 + 1;
        }

    }
}