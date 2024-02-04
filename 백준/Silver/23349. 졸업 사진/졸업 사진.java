import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        Map<String, int[]> timeTable = new HashMap<>(); //각 장소마다의 타임라인
        Map<String,String[]> info = new HashMap<>(); //제출 된 예정 정보
        for(int i = 0; i < n; i++){
            String[] line = bf.readLine().split(" ");
            String[] spotTime = new String[]{line[1],line[2],line[3]};
            if(info.get(line[0]) == null) info.put(line[0], spotTime);
        }

        for(String key : info.keySet()){
            String[] spotTime = info.get(key);
            String spot = spotTime[0];
            int s = Integer.parseInt(spotTime[1]);
            int e = Integer.parseInt(spotTime[2]);

            if(timeTable.get(spot) == null) timeTable.put(spot, new int[50001]);
            int[] time = timeTable.get(spot);
            for(int j = s; j < e; j++){
                time[j]++; //타임라인의 밸류인 배열에, 제출된 시간에 1씩 값을 누적함
            }
        }

        List<String> keys = new ArrayList<>(timeTable.keySet());
        Collections.sort(keys, (s1, s2) -> s1.compareTo(s2));

        String maxSpot = "";
        int maxCtn = 0;
        int[] se = new int[2];

        for (String spot : keys) {
            int[] time = timeTable.get(spot);
            for(int i = 1; i < time.length; i++){
                String tempSpot = spot;
                int tempCtn = time[i];
                int start = i;
                int end = i;

                for(int j = i + 1; j < time.length; j++){
                    if(time[j] != tempCtn) {
                        i = j - 1;
                        break;
                    }
                    else{
                        i = j;
                        end = j;
                    }
                }

                if(maxCtn < tempCtn){
                    maxSpot = tempSpot;
                    maxCtn = tempCtn;
                    se[0] = start;
                    se[1] = end;
                }
            }
        }
        System.out.println(maxSpot + " " + se[0] + " " + (se[1]+1));
    }
}
