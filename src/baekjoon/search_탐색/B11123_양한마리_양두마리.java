package baekjoon.search_탐색;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/** 성공, **/
/** 성공은 했지만 메모리와 시간이 너무 비효율적임 **/
/** 그리고 있어야 성공하지만, 왜 있어야할지 테스트케이스가 보이지 않음 **/
public class B11123_양한마리_양두마리 {
    static int T;
    static int[][] h;
    static int[][] w;
    static char[][][] grid;
    static boolean[][][] checkedGrid;


    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        T = Integer.valueOf(scanner.nextLine());

        h = new int[T][1];
        w = new int[T][1];
        grid = new char[T][][];
        checkedGrid = new boolean[T][][]; //체크 배열

        for (int i = 0; i < T; i++) {

            String[] strHw = scanner.nextLine().split(" ");
            int tempH = Integer.valueOf(strHw[0]);
            int tempW = Integer.valueOf(strHw[1]);
            h[i][0] = tempH;
            w[i][0] = tempW;

            grid[i] = new char[tempH][tempW];
            checkedGrid[i] = new boolean[tempH][tempW]; //체크 배열


            for (int hi = 0; hi < h[i][0]; hi++) {
                String[] lineElements = scanner.nextLine().split("");
                for (int wi = 0; wi < w[i][0]; wi++) {
                    char c = Character.valueOf(lineElements[wi].charAt(0));
                    grid[i][hi][wi] = c;
                }
            }
        }

        for (boolean[][] e : checkedGrid) {

            Arrays.stream(e).forEach(arr -> Arrays.fill(arr,false));

        }
        search();

    }

    private static void search() {
        //현재 로우 인덱스, 현재 컬럼 인덱스, 체크배열,
        for (int t = 0; t < T; t++) {

            Stack<String> sheep = new Stack<>();
            int bevy = 0;
            for (int r = 0; r < grid[t].length; r++) {
                for (int c = 0; c < grid[t][r].length; c++) {


                    recursion(t, r, c, sheep);
                    if(!sheep.empty())
                        bevy++;

                    sheep.clear();

                }
            }

            System.out.println(bevy);
        }
    }

    private static void recursion(int t, int r, int c, Stack<String> sheep) {

        /** 상 탐색은 없어도 된다고 생각했기에 r < 0 부분도 없어도 된다고 생각했음 **/
        if( c < 0 || r < 0 || (r > grid[t].length-1) || (c > grid[t][r].length - 1) )
            return;

        if(grid[t][r][c] == '.' || checkedGrid[t][r][c] == true) //풀이거나 방문 됬다면 처리 안함
        {
            return;
        }

        checkedGrid[t][r][c] = true; //현재 위치의 양을 무리에 포함 시킴
        sheep.push("s");

        /** 상쪽은 검사 안해도 될거 같은데 없으면 실패 **/
        recursion(t,r-1, c, sheep); //상



        recursion(t,r+1, c, sheep); //하
        recursion(t,r, c+1, sheep); //우
        recursion(t,r, c-1, sheep); //좌

    }

}

