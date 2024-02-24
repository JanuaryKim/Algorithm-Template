import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] numInput = Arrays.stream(bf.readLine().split(" ")).mapToInt(i->Integer.parseInt(i)).toArray();
        map = new int[numInput[0]][numInput[1]];
        int inCtn = numInput[2];
        int minHeight = Integer.MAX_VALUE;
        int maxHeight = Integer.MIN_VALUE;

        for(int i = 0; i < numInput[0]; i++){
            String[] line = bf.readLine().split(" ");
            for(int j = 0; j < numInput[1]; j++){
                int height = Integer.parseInt(line[j]);
                map[i][j] = height;
                if(minHeight > height) minHeight = height;
                if(maxHeight < height) maxHeight = height;
            }
        }

        int minTime = Integer.MAX_VALUE;
        int limitHeight = 0;
        for(int i = minHeight; i <= maxHeight; i++){

            int getTime = getSolve(i, inCtn);
            if(getTime < 0) continue;

            if(getTime <= minTime){
                minTime = getTime;
                limitHeight = i;
            }
        }
        System.out.println(minTime + " " + limitHeight);
    }

    private static int getSolve(int limitHeight, int curBlock){


        int time = 0;
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                int blockDiff = limitHeight - map[i][j];

                //플러스면 쌓아 올려야함, 쌓는건 한칸당 1시간
                //마이너스면 깎아야함, 깍는건 한칸당 2시간
                if(blockDiff < 0) {
                    time += (Math.abs(blockDiff) * 2);
                    curBlock += Math.abs(blockDiff);
                }
                else {
                    time += blockDiff;
                    curBlock -= blockDiff;
                }
            }
        }
        if(curBlock < 0)
            time = -1;
        return time;
    }
}
