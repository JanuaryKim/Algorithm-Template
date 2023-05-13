import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<String>();
        for(int i=0;i<N;i++) {
            String[] log = br.readLine().split(" ");
            if(log[1].equals("enter")) {
                set.add(log[0]);
            }
            else {
                set.remove(log[0]);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());
        for(String s : list) {
            sb.append(s+"\n");
        }
        System.out.println(sb);
    }
}