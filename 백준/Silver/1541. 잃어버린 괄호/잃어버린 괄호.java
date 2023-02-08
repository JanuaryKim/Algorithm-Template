import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();

        String[] values = input.split("-");

        String[] bases = values[0].split("\\+");
        int sum = Arrays.stream(bases).mapToInt(i-> Integer.parseInt(i)).sum();

        for (int i = 1; i < values.length; i++) {
            String[] split = values[i].split("\\+");
            sum -= Arrays.stream(split).mapToInt(j->Integer.parseInt(j)).sum();
        }

        System.out.println(sum);
    }
}
