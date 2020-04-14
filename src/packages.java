import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class packages {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokens = new StringTokenizer(read.readLine());

        int[] sizes = new int[5];
        for (int i = 0; i < 5; i++) {
            sizes[i] = Integer.parseInt(tokens.nextToken());
        }
        int packages = Integer.parseInt(tokens.nextToken());

        int[][] options = new int[5][];
        options[0] = new int[]{11, 0, 0, 0, 1};
        options[1] = new int[]{0, 5, 0, 1, 0};
        options[2] = new int[]{0, 0, 4, 0, 0};
        options[3] = new int[]{0, 9, 0, 0, 0};
        options[4] = new int[]{36, 0, 0, 0, 0};

        while (true) {
            int[] option = null;
            for (int i = 0; i < 5; i++) {
                if (sizes[4 - i] > 0) {
                    option = options[i].clone();
                    break;
                }
            }
            if (option != null) {
                packages++;
                for (int i = 4; i >= 0; i--) {
                    if (option[i] > 0) {
                        if (sizes[i] >= option[i]) {
                            sizes[i] -= option[i];
                        } else {
                            int left = option[i] - sizes[i];
                            sizes[i] = 0;
                            if (i == 2) {
                                option[1] += 1 + 2*(left - 1);
                                option[0] += 4 + left;
                            } else if (i == 1) {
                                option[0] += 4*left;
                            }
                        }
                    }
                }
            } else {
                break;
            }
        }
        System.out.println(packages);
    }
}
