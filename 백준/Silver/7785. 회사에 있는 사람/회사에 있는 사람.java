import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        Set<String> set = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            String[] line = bf.readLine().split(" ");
            if(line[1].equals("enter"))
                set.add(line[0]);
            else
                set.remove(line[0]);
        }
 
        StringBuilder sb = new StringBuilder();
        set.stream().sorted(Collections.reverseOrder()).forEach(name-> sb.append(name+"\n"));
        System.out.println(sb);
    }
}