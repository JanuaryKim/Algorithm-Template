import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    private static class Truck{
        int weight;
        int time;

        public Truck(int weight, int time) {
            this.weight = weight;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strNWL = br.readLine().split(" ");
        int n = Integer.parseInt(strNWL[0]);
        int w = Integer.parseInt(strNWL[1]);
        int l = Integer.parseInt(strNWL[2]);
        String[] strTruck = br.readLine().split(" ");
        Queue<Truck> waitTruckQ = new LinkedList<>();
        List<Truck> passTruckL = new LinkedList<>();
        int curWeight = 0;
        int t = 0;

        for(int i = 0; i < strTruck.length; i++){
            waitTruckQ.add(new Truck(Integer.parseInt(strTruck[i]),0));
        }

        while (!waitTruckQ.isEmpty() || !passTruckL.isEmpty()) {

            for(int i = 0; i < passTruckL.size(); i++){
                Truck tr = passTruckL.get(i);
                tr.time++;
            }

            //나감 처림
            if(passTruckL.size() > 0 && passTruckL.get(0).time >= w){
                Truck removedTr = passTruckL.remove(0);
                curWeight -= removedTr.weight;
            }

            //넣는 처리
            if((!waitTruckQ.isEmpty()) && (w > passTruckL.size()) && (curWeight + waitTruckQ.peek().weight <= l)){
                Truck nextTr = waitTruckQ.poll();
                curWeight += nextTr.weight;
                passTruckL.add(nextTr);
            }

            t++;
        }

        System.out.println(t);
    }
}
