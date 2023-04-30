import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Integer> list = new LinkedList<>();

        int dasom = Integer.parseInt(bf.readLine());

        for (int i = 1; i < n; i++) {
            int value = Integer.parseInt(bf.readLine());
            list.add(value);
        }

        Collections.sort(list);
        int result = 0;

        if (n == 1) {
            System.out.println(0);
            return;
        }
        while (dasom <= list.get(list.size()-1)) {

            result++;
            int value = list.get(list.size()-1);
            dasom++;
            list.remove(list.size()-1);
            list.add(value-1);
            Collections.sort(list);
        }

        System.out.println(result);
    }
}
