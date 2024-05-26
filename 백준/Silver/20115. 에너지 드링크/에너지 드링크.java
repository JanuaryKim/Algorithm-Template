import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        double result = 0;
        long maxDrink = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Long[] drinks = Arrays.stream(bf.readLine().split(" ")).mapToLong(Long::parseLong).boxed().toArray(Long[]::new);

        for(int i = 0; i < drinks.length; i++){
            if(maxDrink < drinks[i]) maxDrink = drinks[i];
            result += drinks[i];
        }
        System.out.println((result+maxDrink) /2); //분배법칙 이용 원리
    }
}
    