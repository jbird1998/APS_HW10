import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bus_tour {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(read.readLine()) - 1;

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(read.readLine());
        }

        long max = arr[0];
        long curr = max;
        int start = 1, stop = 2;
        int cStart = 1, cStop = 2;
        for (int i = 1; i < N; i++) {
            long num = arr[i];
            if (curr > max) {
                max = curr;
                start = cStart;
                stop = cStop;
            } else if (curr == max && (cStop - cStart) > (stop - start)) {
                start = cStart;
                stop = cStop;
            }
            if (curr + num < num) {
                curr = num;
                cStart = i + 1;
                cStop = i + 2;
            } else {
                curr += num;
                cStop++;
            }
        }
        if (curr > max) {
            max = curr;
            start = cStart;
            stop = cStop;
        } else if (curr == max && (cStop - cStart) > (stop - start)) {
            start = cStart;
            stop = cStop;
        }
        if (max > 0) {
            System.out.println("The nicest part of Y1 is between stops " + start + " and " + stop);
        } else {
            System.out.println("Yet another overrated tourist destination");
        }
    }
}
