import java.util.*;
import java.io.*;


public class Solve {

    private static String printMerged(int[] merged) {
        StringBuilder sb = new StringBuilder();
        for (int i : merged) {
            sb.append(i).append(" ");
        }
        return sb.toString();

    }
    private static String merge(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;
        int[] merged = new int[a.length+b.length];

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            }
            else {
                merged[k++] = b[j++];
            }
        }

        while (i < a.length) merged[k++] = a[i++];
        while (j < b.length) merged[k++] = b[j++];

        return printMerged(merged);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);

        int[] a = new int[n], b = new int[m];
        line = br.readLine().split(" ");
        for (int i=0; i<n; i++) {
            a[i] = Integer.parseInt(line[i]);
        }
        line = br.readLine().split(" ");
        for (int i=0; i<m; i++) {
            b[i] = Integer.parseInt(line[i]);
        }

        System.out.println(merge(a, b));

    }
}