
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int[] alphabet = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        Integer[] arr = new Integer[a.length() * 2];
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            char c1 = b.charAt(i);
            arr[2 * i] = alphabet[c - 65];
            arr[(2 * i) + 1] = alphabet[c1 - 65];
        }

        List<Integer> list = Arrays.asList(arr);
        while (list.size() > 2) {
            List<Integer> temp = new ArrayList<>();
            for (int d = 0; d < list.size() - 1; d++) {
                temp.add((list.get(d) + list.get(d + 1)) % 10);
            }
            list = temp;
        }

        list.forEach(i -> System.out.print(i));
    }

}