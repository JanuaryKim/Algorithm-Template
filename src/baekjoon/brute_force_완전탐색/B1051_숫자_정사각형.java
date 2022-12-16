package baekjoon.brute_force_완전탐색;

import java.util.Scanner;

/** 성공 , 마감 - 2022-12-12 **/
public class B1051_숫자_정사각형 {
    static int[][] map;
    static int maxSize = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int min = Math.min(n, m);

        map = new int[n][m];
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
               map[i][j] = Integer.valueOf(String.valueOf(line.charAt(j)));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tempMaxSize = check(min, i, j,map);
                if (maxSize <= tempMaxSize) maxSize = tempMaxSize;
            }
        }

        System.out.println(maxSize);
    }

    static int check(int min, int row, int col, int[][] map) {

        //기본은 현재 인덱스에서 0 ~ min 만큼씩 꼭지점 위치에 값만 확인 하면 됨.
        //그러나 현재 row, col이 ~min 까지 늘리 수 없는 상황이라면 최대 row, col 보다 작은 경우

        int increase = 0;
        int maxSize = 0;

        while (increase <= min) {

            if((map[row][col] == map[row + increase][col])
                    && (map[row][col] == map[row][col + increase])
                    && (map[row][col] == map[row + increase][col + increase]))
            {
                int temp = (int) Math.pow(increase + 1, 2);
                maxSize = maxSize < temp ? temp : maxSize;
            }

            increase++;

            if((row + increase) >= map.length || (col + increase) >= map[0].length)
                   break;
        }
        return maxSize;
    }
}
