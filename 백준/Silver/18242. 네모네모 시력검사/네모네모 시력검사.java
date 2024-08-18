import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] strNM = bf.readLine().split(" ");

        int n = Integer.parseInt(strNM[0]);
        int m = Integer.parseInt(strNM[1]);

        // 발견체크 변수 false
        // 변 길이 = 0;
        // 행 반복
        //  열 반복
        //      만약 # 발견시
        //          행, 열 인덱스 기억

        // int maxColLeng = 0;
        // 행 고정, 열 증가 (상단 최대 길이 구하기)
        //  maxColLeng = 구한 값 넣기

        // int maxRowLeng = 0;
        // 열 고정, 행 증가 (좌측 최대 길이 구하기)
        //  maxRowLeng = 구한 값 넣기

        // 만약 maxColLeng과 maxRowLeng이 같지 않다면
        //  둘중에 하나가 구멍 뚫린것
        // 만약 둘의 값이 같다면
        //  1. (최초 발견 행 + 최대길이) 고정, 열을 위에서 구한 최대값으로 증가시켜 연속된 #의 길이를 구함
        //  2. (최초 발견 열 + 최대길이) 고정, 행을 위에서 구한 최대값으로 증가시켜 연속된 #의 길이를 구함

        char[][] map = new char[n][m];
        int sRow = 0;
        int sCol = 0;
        for(int i = 0; i < n; i++){
            String line = bf.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = line.charAt(j);
            }
        }

        for(int i = 0; i < n; i++){
            boolean find = false;
            for(int j = 0; j < m; j++){
                if(map[i][j] == '#') {
                    sRow = i;
                    sCol = j;
                    find = true;
                    break;
                }
            }
            if(find) break;
        }

        int maxUpLeng = 0;
        //상단 길이 구하기
        for(int i = sCol; i < m; i++){
            if(map[sRow][i] == '#') maxUpLeng++;
            else break;
        }

        int maxLeftLeng = 0;
        //좌측 길이 구하기
        for(int i = sRow; i < n; i++){
            if(map[i][sCol] == '#') maxLeftLeng++;
            else break;
        }

        if(maxUpLeng == maxLeftLeng){
            int maxDownLeng = 0;
            //하단 길이 구하기
            for(int i = sCol; i < m; i++){
                if(map[sRow + maxLeftLeng - 1 ][i] == '#') maxDownLeng++;
                else break;
            }

            int maxRightLeng = 0;
            //우측측 길이 구하기
            for(int i = sRow; i < n; i++){
                if(map[i][sCol+maxUpLeng - 1] == '#') maxRightLeng++;
                else break;
            }
            if(maxDownLeng < maxRightLeng) System.out.println("DOWN");
            else System.out.println("RIGHT");
        }
        else{
            if(maxUpLeng < maxLeftLeng) System.out.println("UP");
            else System.out.println("LEFT");

        }

    }
}
