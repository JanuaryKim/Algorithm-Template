import java.util.*;

class Solution {
    public int solution(String dirs) {
        int[] dr = {-2, 2, 0, 0}, dc = {0, 0, -2, 2};
        int[] dr2 = {-1, 1, 0, 0}, dc2 = {0, 0, -1, 1};
        int result = 0;
        int row = 10, col = 10;
        boolean[][] map = new boolean[21][21];

        for(int i = 0; i < dirs.length(); i++){
            char d = dirs.charAt(i);
            
            int dir = -1;
            if(d == 'U')
                dir = 0;
            else if(d == 'D')
                dir = 1;
            else if(d == 'L')
                dir = 2;
            else if(d == 'R')
                dir = 3;
            
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            if(nr < 0 || nc < 0 || nr >= map.length || nc >= map[0].length)
                continue;
            
            if(!map[row + dr2[dir]][col + dc2[dir]]) {
                result++;
                map[row + dr2[dir]][col + dc2[dir]] = true;
            }
            row = nr;
            col = nc;
        }
        return result;
    }
}