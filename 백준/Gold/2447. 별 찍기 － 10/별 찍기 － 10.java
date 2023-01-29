import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        arr = new char[n][n];

        makeStar(0,0, n);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == '*')
                    sb.append("*");
                else
                    sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void makeStar(int row, int col, int size) {

        if(size == 1){
            arr[row][col] = '*';
            return;
        }

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){

                if(!(i==1 && j==1))          
                    makeStar(row + i*size/3, col + j*size/3, size/3);
            }
        }
    }
}