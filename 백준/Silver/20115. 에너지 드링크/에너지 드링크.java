import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        double result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Long[] drinks = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).boxed().toArray(Long[]::new);
        Arrays.sort(drinks, (d1, d2) -> {
            return d2 > d1 ? 1 : (d2 < d1 ? -1 : 0);
        });

        result += drinks[0];

        for(int i = drinks.length-1; i > 0; i--){
            result += ((double)drinks[i] / 2);
        }
        System.out.println(result);

    }
}
