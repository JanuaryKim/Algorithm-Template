import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    static Ball[] balls;
    static int result = 0;
    static int l, n, t;

    private static class Ball{
        short pos;
        char dir;

        public Ball(short pos, char dir) {
            this.pos = pos;
            this.dir = dir;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strLNT = br.readLine().split(" ");
        l = Integer.parseInt(strLNT[0]);
        n = Integer.parseInt(strLNT[1]);
        t = Integer.parseInt(strLNT[2]);
        int time = 0;

        balls = new Ball[n];
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            Ball b = new Ball(Short.parseShort(input[0]), input[1].charAt(0));
            balls[i] = b;
        }

        while (++time <= t) {
            move();
            crash();
        }

        System.out.println(result);
    }

    private static void crash(){

        //좌측벽 처리
        for(int i = 0; i < n; i++){
            Ball b = balls[i];
            if(b.pos == 0){
                b.dir = 'R';
            }
        }

        for(int i = 1; i < l; i++){
            List<Ball> ballList = new ArrayList<>();
            for(int j = 0; j < n; j++){
                Ball b = balls[j];
                if(b.pos == i) ballList.add(b);
            }

            if(ballList.size() > 1) {
                for(Ball b : ballList) {
                    b.dir = b.dir == 'R' ? 'L' : 'R';
                }
                result++;
            }
        }

        //우측벽 처리
        for(int i = 0; i < n; i++){
            Ball b = balls[i];
            if(b.pos == l){
                b.dir = 'L';
            }
        }
    }

    private static void move(){
        for(int i = 0; i < balls.length; i++){
            Ball b = balls[i];

            if(b.dir == 'R'){
                b.pos++;
                if(b.pos > l) {
                    b.pos = (short)(l-1);
                    b.dir = 'L';
                }
            }
            else{
                b.pos--;
                if(b.pos < 0) {
                    b.pos = (short)1;
                    b.dir = 'R';
                }
            }
        }
    }

}
