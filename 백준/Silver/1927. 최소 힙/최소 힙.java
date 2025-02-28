import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        MinHeap mh = new MinHeap(n);

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (mh.size() > 0) {
                    bw.write(mh.remove() + "\n");
                } else {
                    bw.write("0\n");
                }
            } else {
                mh.add(input);
            }
        }

        bw.flush();

        bw.close();
        br.close();
    }

    static class MinHeap {
        private int[] tree;
        private int size;
        public MinHeap(int length) {
            tree = new int[length];
            size = 0;
        }

        public int size() {
            return size;
        }

        public void add(int value) {
            tree[size] = value;

            int current = size;
            size++;
            while (current > 0) {
                int parent = getParent(current);
                if (tree[parent] > tree[current]) {
                    swap(parent, current);
                    current = parent;
                } else {
                    break;
                }
            }
        }

        public int remove() {
            int value = tree[0];
            tree[0] = tree[--size];

            int current = 0;

            while (true) {
                int c1 = firstChild(current);
                int c2 = c1 + 1;

                int sc = current;
                if (c1 < size && tree[current] > tree[c1]) {
                    sc = c1;
                }
                if (c2 < size && tree[sc] > tree[c2]) {
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
            int temp = tree[a];
            tree[a] = tree[b];
            tree[b] = temp;
        }

        private int firstChild(int idx) {
            return idx * 2 + 1;
        }

    }

}
