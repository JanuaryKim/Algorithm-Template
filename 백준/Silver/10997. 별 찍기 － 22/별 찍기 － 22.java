import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n == 1) {
            System.out.println("*");
        }
        else{
            int col = 4 * n - 3;
            int row = col + 2;

            char[][] map = new char[row][col];


            for(int i = 0; i < row; i++){
                Arrays.fill(map[i],' ');
            }

            int rightToLeft = col - 1;
            int leftLimit = 0;

            int topToBottom = 0;
            int bottomLimit = row - 1;

            int leftToRight = 0;
            int rightLimit = col - 1;

            int bottomToTop = row - 2;
            int topLimit = 2;


            int curRow = 0;
            int curCol = 0;

            int tempRow = 0;
            int tempCol = 0;

            while(n >= 2){

                //위에 가로 그리기, ←
                for(tempCol = rightToLeft; tempCol >= leftLimit; tempCol--){
                    map[curRow][tempCol] = '*';
                }

                curCol = tempCol + 1;

                //아래로 세로 그리기, ↓
                for(tempRow = topToBottom; tempRow <= bottomLimit; tempRow++){
                    map[tempRow][curCol] = '*';
                }

                curRow = tempRow - 1;

                //아래에 가로 그리기, →
                for(tempCol = leftToRight; tempCol <= rightLimit; tempCol++){
                    map[curRow][tempCol] = '*';
                }

                curCol = tempCol - 1;

                //위로 세로 그리기, ↑
                for(tempRow = bottomToTop; tempRow >= topLimit; tempRow--){
                    map[tempRow][curCol] = '*';
                }

                curRow = tempRow + 1;

                map[curRow][curCol - 1] = '*';

                if(n == 2)
                    break;

                rightToLeft -= 2;
                leftLimit += 2;

                topToBottom += 2;
                bottomLimit -= 2;

                leftToRight += 2;
                rightLimit -= 2;

                bottomToTop -= 2;
                topLimit += 2;

                n--;
            }

            //마지막 역기역 그리기
            map[curRow][curCol - 1] = '*';
            map[curRow][curCol - 2] = '*';
            map[curRow + 1][curCol - 2] = '*';
            map[curRow + 2][curCol - 2] = '*';
            
            for(int i = 0; i < row; i++){
                if(i == 1) {
                    System.out.println('*');
                    continue;
                }
                for(int j = 0; j < col; j++){
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

        }
    }
}
