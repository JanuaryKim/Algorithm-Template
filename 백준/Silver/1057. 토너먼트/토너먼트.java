import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bf.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int jimin = Integer.parseInt(inputs[1]);
        int hansoo = Integer.parseInt(inputs[2]);

        List<Integer> pre = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            pre.add(i);
        }


        int depth = 0;
        while (pre.size() > 1) {

            depth++;
            List<Integer> next = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();

            for (int i = 0; i < pre.size(); i++) {
                Integer current = pre.get(i);
                temp.add(current);

                if(temp.size() == 2)
                {
                    if (temp.contains(jimin) && temp.contains(hansoo)) {
                        System.out.println(depth);
                        return;
                    } else if (temp.contains(jimin)) {
                        next.add(jimin);
                    } else if (temp.contains(hansoo)) {
                        next.add(hansoo);
                    } else{
                        next.add(temp.get(0));
                    }

                    temp.clear();
                }
            }

            if(!temp.isEmpty())
                next.add(temp.get(0));

            pre = new ArrayList<>(next);
            next.clear();
        }

        System.out.println(-1);
    }
}
