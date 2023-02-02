import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static int[][] map;
    static List<Integer[]> chickenStorePst = new ArrayList<>();
    static List<Integer[]> housePst = new ArrayList<>();
    static int cityChickenDis = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if(input == 1)
                    housePst.add(new Integer[]{i,j});
                else if(input == 2)
                    chickenStorePst.add(new Integer[]{i,j});
            }
        }
        getCombi(0, 0, new ArrayList<>());
        System.out.println(cityChickenDis);
    }

    static void getCombi(int depth, int index, List<Integer[]> combination) {

        if (depth == m) {
            int sum = 0;
            for (int i = 0; i < housePst.size(); i++) {
                int min =Integer.MAX_VALUE;
                for (int j = 0; j < combination.size(); j++) {
                    Integer[] house = housePst.get(i);
                    int dis = Math.abs(house[0] - combination.get(j)[0]) + Math.abs(house[1] - combination.get(j)[1]);
                    if(min > dis)
                        min = dis;

                }
                sum += min;
            }
            if(sum < cityChickenDis)
                cityChickenDis = sum;
        }

        for (int i = index; i < chickenStorePst.size(); i++) {
            combination.add(chickenStorePst.get(i));
            getCombi(depth+1,i+1,combination);
            combination.remove(combination.size()-1);
        }
    }
}
