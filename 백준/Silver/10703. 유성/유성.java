import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] map;
    static int r, s;
    static int[] sArr;
    static int[] continueArr;
    static int minContinue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strInput = br.readLine().split(" ");

        r = Integer.parseInt(strInput[0]);
        s = Integer.parseInt(strInput[1]);

        sArr = new int[s];
        continueArr = new int[s];

        map = new char[r][s];
        for(int i = 0; i < r; i++){
            map[i] = br.readLine().toCharArray();
        }

        research();

        for(int i = 0; i < s; i++){
            if(continueArr[i] == 0) continue;
            minContinue = Math.min(minContinue, continueArr[i]);
        }

        fallOut();

        //출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < s; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void fallOut(){

        for(int i = 0; i < s; i++){
            if(sArr[i] == -1) continue;

            for(int j = sArr[i]; j >= 0; j--){

                if(map[j][i] != 'X') continue;

                //swap
                map[j][i] = '.';
                map[j + minContinue][i] = 'X';
            }
        }
    }

    private static void research(){

        //X - 1
        //. - 2
        //# - 3

        for(int i = 0; i < s; i++){
            int state = 0;
            int continueCnt = 0;
            sArr[i] = -1;
            for(int j = 0; j < r; j++){
                if(state == 0 && map[j][i] == 'X'){
                    state = 1;
                }
                else if(state == 1 && map[j][i] == '.'){
                    state = 2;
                    sArr[i] = j - 1; //마지막 X행 기억
                    continueCnt++;
                }
                else if(state == 2 && map[j][i] == 'X'){
                    sArr[i] = j; //가장 마지막 X 지점 재설정
                    continueCnt = 0; //. 나오다가 다시 X가 나온경우 초기화
                }
                else if(state == 2 && map[j][i] == '.'){
                    continueCnt++;
                }
                else if(state == 2 && map[j][i] == '#'){
                    state = 3;
                }
            }

            continueArr[i] = continueCnt;
        }
    }
}
