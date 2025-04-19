import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Participant> scoresList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                Participant participant = new Participant(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                scoresList.add(participant);
            }
            scoresList.sort(Comparator.comparingInt(Participant::getA).thenComparing(Participant::getB));
            int minB = Integer.MAX_VALUE;
            for (int i = 0; i < scoresList.size(); i++) {
                int b = scoresList.get(i).getB();
                if (b < minB) {
                    minB = b;
                }
                scoresList.get(i).setC(minB);
            }
            for (int i = scoresList.size() - 1; i >= 1; i--) {
                Participant me = scoresList.get(i);
                Participant other = scoresList.get(i - 1);
                if (other.getC() < me.getB()) {
                    me.setRemoved(true);
                }
            }
            scoresList.sort(Comparator.comparingInt(Participant::getB).thenComparing(Participant::getA));
            int minA = Integer.MAX_VALUE;
            for (int i = 0; i < scoresList.size(); i++) {
                int a = scoresList.get(i).getA();
                if (a < minA) {
                    minA = a;
                }
                scoresList.get(i).setC(minA);
            }
            for (int i = scoresList.size() - 1; i >= 1; i--) {
                Participant me = scoresList.get(i);
                Participant other = scoresList.get(i - 1);
                if (other.getC() < me.getA()) {
                    me.setRemoved(true);
                }
            }

            System.out.println(scoresList.stream().filter(p -> !p.isRemoved()).count());
        }
    }

    private static class Participant {
        int a;
        int b;
        int c;
        boolean isRemoved;

        public Participant(int a, int b) {
            this.a = a;
            this.b = b;
            this.isRemoved = false;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public boolean isRemoved() {
            return isRemoved;
        }

        public void setRemoved(boolean removed) {
            isRemoved = removed;
        }
    }
}