import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class max_sum {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine());
        StringTokenizer tokens = new StringTokenizer(read.readLine());

        if (tokens.countTokens() != N) {
            N = tokens.countTokens();
        }
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(tokens.nextToken());
        }

        long max = arr[0];
        long curr = max;
        for (int i = 1; i < N; i++) {
            long num = arr[i];
            if (curr > max) {
                max = curr;
            }
            if (curr + num < num) {
                curr = num;
            } else {
                curr += num;
            }
        }
        if (curr > max) {
            max = curr;
        }
        System.out.println(max);
    }
}
