import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//14612
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] strNM = bf.readLine().split(" ");
        int n = Integer.parseInt(strNM[0]);
        int m = Integer.parseInt(strNM[1]);

        List<Order> orders = new LinkedList<>();
        for(int i = 0; i < n; i++){
            String[] line = bf.readLine().split(" ");
            String comm =  line[0];

            if(comm.equals("order")){
                int num =  Integer.parseInt(line[1]);
                int t =  Integer.parseInt(line[2]);
                orders.add(new Order(num ,t));
            }
            else if(comm.equals("sort")){
                Collections.sort(orders, (o1, o2) -> {
                    if(o1.time == o2.time){
                        return o1.tbNum - o2.tbNum;
                    }
                    else{
                        return o1.time - o2.time;
                    }
                });
            }
            else{
                int comTableNum = Integer.parseInt(line[1]);
                orders.removeIf((o) -> {
                    return o.tbNum == comTableNum;
                });
            }

            if(!orders.isEmpty()) {
                orders.forEach((o) -> sb.append(o.tbNum + " "));
            }
            else
                sb.append("sleep");

            sb.append("\n");
        }
        System.out.println(sb);

    }
    private static class Order{
        int tbNum;
        int time;

        public Order(int tbNum, int time) {
            this.tbNum = tbNum;
            this.time = time;
        }
    }
}
