import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DeongChi[] deongChis = new DeongChi[n];
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int height = sc.nextInt();
            deongChis[i] = new DeongChi(weight, height);
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                if (i == j)
                    continue;

                if (deongChis[j].getWeight() > deongChis[i].getWeight() && deongChis[j].getHeight() > deongChis[i].getHeight()) {
                    rank++;
                }
            }
            System.out.printf("%d ", rank);
        }
    }
    
    static class DeongChi {
        private int weight;
        private int height;
        public DeongChi(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }
    }
}
