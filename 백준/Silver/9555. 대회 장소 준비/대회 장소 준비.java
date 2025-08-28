import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {

        StringBuilder sb = new StringBuilder();

        int[] cr = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] cc = {0, 1, 1, 1, 0, -1, -1, -1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++){
            HashMap<Integer, Boolean> checkMap = new HashMap<>();
            int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[][] map = new int[nm[0]][nm[1]];
            int adjacentCnt = 0;
            for(int j = 0; j < nm[0]; j++){
                int[] line = Arrays.stream(br.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                map[j] = line;
            }

            for(int j = 0; j < nm[0]; j++){
                for(int z = 0; z < nm[1]; z++){
                    int id = map[j][z];
                    if(id == -1) continue;
                    Boolean check = checkMap.get(id);
                    if(check != null) continue;

                    for(int w = 0; w < 8; w++){
                        int nextR = j + cr[w];
                        int nextC = z + cc[w];

                        if(nextR >= nm[0] || nextR < 0 || nextC >= nm[1] || nextC < 0) continue;
                        if(map[nextR][nextC] == id) {
                            adjacentCnt++;
                            checkMap.put(id, true);
                            break;
                        }
                    }
                }
            }
            sb.append(adjacentCnt);
            if(i < t-1) sb.append("\n");
        }
        System.out.println(sb);
    }
}
