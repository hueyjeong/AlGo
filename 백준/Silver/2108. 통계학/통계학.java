import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] numbers = new int[n];
        Dictionary<Integer, Integer> dic = new Hashtable<>();
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            if (dic.get(numbers[i]) == null) {
                dic.put(numbers[i], 0);
            }
            dic.put(numbers[i], dic.get(numbers[i]) + 1);

            if (numbers[i] < min) {
                min = numbers[i];
            }

            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        Iterator<Integer> it = dic.keys().asIterator();
        List<int[]> frequents = new ArrayList<>(dic.size());
        while (it.hasNext()) {
            int key = it.next();
            int value = dic.get(key);
            frequents.add(new int[] { key, value});
        }
        frequents.sort((a, b) -> {
            if (a[1] > b[1]) {
                return 1;
            } else if (a[1] == b[1]) {
                return Integer.compare(b[0], a[0]);
            } else {
                return -1;
            }
        });

        int[] mostFrequent = frequents.get(frequents.size() - 1);
        if (frequents.size() > 1) {
            int[] secondFrequent = frequents.get(frequents.size() - 2);
            if (secondFrequent[1] == mostFrequent[1]) {
                mostFrequent = secondFrequent;
            }
        }


        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
        }
        long avg = Math.round((double)sum / n);

        Arrays.sort(numbers);
        int central = numbers[(numbers.length / 2)];

        bw.write(avg + "\n");
        bw.write(central + "\n");
        bw.write(mostFrequent[0] + "\n");
        bw.write(Math.abs(max - min) + "\n");


        bw.flush();

        bw.close();
        br.close();
    }
}