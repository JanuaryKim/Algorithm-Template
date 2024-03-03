import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splNM = bf.readLine().split(" ");
        int n = Integer.parseInt(splNM[0]);
        int m = Integer.parseInt(splNM[1]);
        Set<String> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            set.add(bf.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            String blogKeyword = bf.readLine();
            String[] keywordArr = blogKeyword.split(",");
            for(String k : keywordArr){
                set.remove(k);
            }
            sb.append(set.size());
            if(i != m-1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
