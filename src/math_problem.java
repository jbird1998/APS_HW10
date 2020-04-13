import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class math_problem {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(read.readLine());
        int[] gapCounts = new int[115]; // did you know the largest prime gap between 0 and 1000000 is 114?
        int a = Integer.parseInt(tokens.nextToken());
        int b = Integer.parseInt(tokens.nextToken());
        if (a < 2) {
            a = 2;
        }
        if (a == b) {
            System.out.println(-1);
            return;
        }
        int intLen = b - a + 1;
        boolean[] interval = new boolean[intLen];
        boolean[] sieve = new boolean[((int) Math.sqrt(b)) + 1];
        sieve[0] = true;
        sieve[1] = true;
        for (int i = 2; i < sieve.length; i++) {
            if (!sieve[i]) {
                for (int j = i; j < sieve.length; j += i) {
                    sieve[j] = true;
                }
                int point = a;
                while (point % i != 0 || (point % i == 0 && point == i) && (point - a) < intLen) {
                    point++;
                }
                if ((point - a) == intLen) {
                    continue;
                }
                for (int j = point - a; j < intLen; j += i) {
                    interval[j] = true;
                }
            }
        }
        int low = 0;
        int high = 0;
        while (high < intLen) {
            while (low < intLen && interval[low]) {
                low++;
            }
            high = low + 1;
            while (high < intLen && interval[high]) {
                high++;
            }
            if (high >= intLen) {
                break;
            }
            int curr = high - low;
            gapCounts[curr]++;
            low = high;
        }
        int max = -1;
        int gap = -1;
        for (int i = 1; i < gapCounts.length; i++) {
//            if (gapCounts[i] > 0) {
//                System.out.println(i + ": " + gapCounts[i]);
//            }
            if (gapCounts[i] > max) {
                max = gapCounts[i];
                gap = i;
            } else if (gapCounts[i] == max) {
                gap = -1;
            }
        }
        System.out.println(gap);
    }
}
