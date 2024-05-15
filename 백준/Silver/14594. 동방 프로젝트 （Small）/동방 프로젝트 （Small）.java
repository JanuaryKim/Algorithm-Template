import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//14594
public class Main {
    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        int[] room = new int[n];
        for(int i = 0; i < n; i++) room[i] = i;

        for(int i = 0; i < m; i++){
            String[] splStr = bf.readLine().split(" ");
            int s = Integer.parseInt(splStr[0]);
            int e = Integer.parseInt(splStr[1]);


            if(e != n){
                int eRoomIdx = room[e-1];
                for(int j = e; j < n; j++){
                    if(room[j] == eRoomIdx) e++;
                }
            }
            int roomIdx = room[s-1];
            for(int j = s-1; j < e; j++){

                room[j] = roomIdx;

            }

        }

        int compareRoomIdx = -1;
        for(int i = 0; i < n; i++){
            if(room[i] != compareRoomIdx){
                compareRoomIdx = room[i];
                result++;
            }
        }
        System.out.println(result);
    }
}
