import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static char[][] board;
    static int n;
    static int maxContinue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = bf.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //열 교환
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    checkContinueLine();
                    swap(i, j, i, j + 1);
                }

                //행 교환
                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    checkContinueLine();
                    swap(i, j, i + 1, j);
                }
            }
        }
        System.out.println(maxContinue);
    }

    private static void swap(int y1, int x1, int y2, int x2) {
        char temp = board[y1][x1];
        board[y1][x1] = board[y2][x2];
        board[y2][x2] = temp;
    }

    private static int checkContinueLine() {
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                int tempMax = 0;
                //열 확인
                for (int z = j; z < n; z++) {
                    if (board[i][z] == c)
                        tempMax++;
                    else
                        break;
                }

                maxContinue = Math.max(maxContinue, tempMax);
                tempMax = 0;

                //행 확인
                for (int z = i; z < n; z++) {
                    if (board[z][j] == c) {
                        tempMax++;
                    } else
                        break;
                }
                maxContinue = Math.max(maxContinue, tempMax);
            }
        }
        return result;
    }
}
