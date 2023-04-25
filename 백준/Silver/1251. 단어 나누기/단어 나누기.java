import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String str = bf.readLine();
        List<String> list = new LinkedList<>();
        
        for (int i = 1; i < str.length() - 1; i++) { // 0부터 i < str.length() - 1 인덱스까지 (까지의 인덱스를 포함 X)
            for (int j = i+1; j < str.length(); j++) {

                String s1 = reverse(str.substring(0, i));
                String s2 = reverse(str.substring(i, j));
                String s3 = reverse(str.substring(j));
                list.add(s1 + s2 + s3);
            }
        }

        Collections.sort(list);
        System.out.println(list.get(0));
    }

    static String reverse(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString();
    }
}
