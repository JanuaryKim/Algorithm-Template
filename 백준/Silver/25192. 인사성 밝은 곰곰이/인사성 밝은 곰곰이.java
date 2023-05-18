import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int result = 0;
        Set<String> set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < n; i++) {

            String input = bf.readLine();
            if (input.equals("ENTER")) {

                if (flag) {
                    result += set.size();
                    set.clear();
                }
                flag = true;
                continue;
            }

            if (flag) {
                set.add(input);
            }
        }

        if(!set.isEmpty())
            result += set.size();
        System.out.println(result);
    }
}
