import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//2852
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        String[] input = new String[n+1];
        input[n] = "0 48:00";

        int[] time = new int[3];
        int[] score = new int[3];
        int winTeamIdx = 0;
        for(int i = 0; i < n; i++){
            input[i] = bf.readLine();
        }

        for(int i = 0; i < n; i++){
            String line = input[i];

            String[] splStr = line.split(" ");
            score[Integer.parseInt(splStr[0])]++;
            winTeamIdx = score[1] > score[2] ? 1 : score[1] < score[2] ? 2 : 0;
            if(winTeamIdx == 0) continue;

            String[] nextSplStr = input[i+1].split(" ");
            time[winTeamIdx] += getTimeDiff(splStr[1], nextSplStr[1]);
        }

        System.out.println(convertTime(time[1]));
        System.out.println(convertTime(time[2]));
    }

    private static String convertTime(int intTime){

        int minute= 0;
        int second = 0;

        minute = intTime / 60;
        second = intTime % 60;

        return String.format("%02d:%02d", minute, second);
    }
    private static int getTimeDiff(String strPreTime, String strNextTime){

        int preTime = 0;
        int nextTime = 0;
        String[] splStrPreTime = strPreTime.split(":");
        String[] splStrNextTime = strNextTime.split(":");

        preTime += (60 * Integer.parseInt(splStrPreTime[0])) + Integer.parseInt(splStrPreTime[1]);
        nextTime += (60 * Integer.parseInt(splStrNextTime[0])) + Integer.parseInt(splStrNextTime[1]);

        return nextTime - preTime;
    }
}
