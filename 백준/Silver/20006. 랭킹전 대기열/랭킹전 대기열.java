import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {


        //이중 배열로 각 방을 나타냄
        //이차원 인덱스가 방의 순번, 일차원 배열에 => 중심 레벨, 현재 인원
        //Map 생성 => 방 생성과 동시에 방의 순번을 키, String[] 형태로 레벨과 닉네임 저장


        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] splInput = bf.readLine().split(" ");
        int p = Integer.parseInt(splInput[0]);
        int m = Integer.parseInt(splInput[1]);

        String[][] attendMembers = new String[p][2];
        for(int i = 0; i < p; i++){
            attendMembers[i] = bf.readLine().split(" ");
        }

        List<int[]> rooms = new ArrayList<>();
        Map<Integer,List<String[]>> enterList = new HashMap<>();
        for(int i = 0; i < p; i++){
            String[] splPlayer = attendMembers[i];
            int lv = Integer.parseInt(splPlayer[0]);

            boolean join = false;
            for(int j = 0; j < rooms.size(); j++){
                int[] r = rooms.get(j);
                if(r[1] < m){
                    if(r[0] + 10 >= lv && r[0] - 10 <= lv){

                        join = true;
                        r[1]++; //인원 증가
                        List<String[]> list = enterList.get(j);
                        list.add(splPlayer); //참가
                        break;
                    }
                }

            }
            if(!join) {
                int[] newRoom = new int[]{lv, 1};
                rooms.add(newRoom); //방 생성
                List<String[]> attend = new ArrayList<>();
                attend.add(splPlayer);
                enterList.put(rooms.size()-1, attend); //참석
            }


        }

        for(int i = 0; i < rooms.size(); i++){
            int[] r = rooms.get(i);
            if(r[1] == m)
                System.out.println("Started!");
            else
                System.out.println("Waiting!");

            List<String[]> attendList = enterList.get(i);
            Collections.sort(attendList, (m1, m2) -> m1[1].compareTo(m2[1]));
            for (String[] player : attendList) {
                System.out.println(player[0] + " " + player[1]);
            }
        }
    }


}
