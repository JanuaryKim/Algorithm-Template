import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        int[] directionR = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] directionS = {0, 1, 1, 1, 0, -1, -1, -1};
        int result = 0;
        int maxSangCnt = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strInput = br.readLine().split(" ");
        int r = Integer.parseInt(strInput[0]);
        int s = Integer.parseInt(strInput[1]);

        char[][] map = new char[r][];
        for(int i = 0; i < r; i++){
            map[i] = br.readLine().toCharArray();
        }

        for(int i = 0; i < r; i++){
            for(int j = 0; j < s; j++){
                int nextR;
                int nextS;
                if(map[i][j] == 'o'){
                    int hsCnt = 0;
                    for(int z = 2; z < 6; z++){
                        nextR = i + directionR[z];
                        nextS = j + directionS[z];

                        if((nextR < 0 || nextR >= r) || (nextS < 0 || nextS >= s)){
                            continue;
                        }
                        if(map[nextR][nextS] == 'o') {
                            hsCnt++;
                        }
                    }
                    result += hsCnt;
                }
                else{
                    int tempHsCnt = 0;
                    for(int z = 0; z < 8; z++){
                        nextR = i + directionR[z];
                        nextS = j + directionS[z];

                        if((nextR < 0 || nextR >= r) || (nextS < 0 || nextS >= s)){
                            continue;
                        }
                        if(map[nextR][nextS] == 'o') tempHsCnt++;
                    }

                    if(maxSangCnt < tempHsCnt) maxSangCnt = tempHsCnt;
                }
            }
        }
        System.out.println(result + maxSangCnt);
    }
}
