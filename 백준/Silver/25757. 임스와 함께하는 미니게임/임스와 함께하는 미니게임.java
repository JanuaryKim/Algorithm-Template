import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bf.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int count = 0;

        if(inputs[1].equals("Y"))
            count = 1;
        else if(inputs[1].equals("F"))
            count = 2;
        else
            count = 3;

        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(bf.readLine());
        }
        System.out.println(set.size()/count);
    }
}
