import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] numbers = new String[n];
        int numberLength;

        for (int i = 0; i < n; i++) {
            numbers[i] = bf.readLine();
        }

        numberLength = numbers[0].length();

        List<String> list = new ArrayList<>();

        for (int i = numberLength-1; i >= 0; i--) {

            for (int j = 0; j < n; j++) {

                String subStr = numbers[j].substring(i, numberLength);
                if (list.contains(subStr)) {
                    list.clear();
                    break;
                } else {
                    list.add(subStr);
                }
            }

            if (list.size() != 0) {
                System.out.println(numberLength - i);
                return;
            }
        }
    }
}
