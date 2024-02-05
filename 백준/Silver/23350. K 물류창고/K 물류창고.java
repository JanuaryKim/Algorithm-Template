import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] splLine = bf.readLine().split(" ");
        int n = Integer.parseInt(splLine[0]);
        int m = Integer.parseInt(splLine[1]);
        int curM = m;
        int[] priorityConCtn = new int[m+1];
        Queue<int[]> q = new LinkedList<>();
        Stack<int[]> s = new Stack<>();
        for(int i = 0; i < n; i++){
            splLine = bf.readLine().split(" ");
            int priority = Integer.parseInt(splLine[0]);
            int weight = Integer.parseInt(splLine[1]);
            int[] container = new int[]{priority, weight};
            priorityConCtn[priority]++; //우선순위별 컨테이너 갯수 체크
            q.add(container);
        }

        while(!q.isEmpty()){
            Stack<int[]> cloneS = (Stack<int[]>)s.clone();

            int[] con = q.poll();
            if(con[0] < curM){ //현재 우선순위 보다 높은경우
                if(checkLowPriorityCtn(con[0], priorityConCtn)){
                    s.add(con);
                    priorityConCtn[con[0]]--;
                    curM--;
                } else{
                    q.add(con);
                }
                result += con[1];
            } else if (con[0] == curM) { // 현재 우선순위와 같은 경우
                if(!s.isEmpty() && s.peek()[1] < con[1]) //꺼내져 쌓인 컨테이너가 더 무겁다면
                {
                    Stack<int[]> tempS = new Stack<>();
                    while(!s.isEmpty() && s.peek()[0] == con[0] && s.peek()[1] < con[1]){
                        int[] tempCon = s.pop();
                        tempS.push(tempCon);
                        result += tempCon[1];
                    }

                    s.push(con);
                    priorityConCtn[con[0]]--;
                    result += con[1];

                    while(!tempS.isEmpty()){
                        int[] tempCon = tempS.pop();
                        s.push(tempCon);
                        result += tempCon[1];
                    }
                }
                else{
                    s.push(con);
                    priorityConCtn[con[0]]--;
                    result += con[1];

                }
            } else { //현재 우선순위 보다 작은 경우
                s.push(con);
                priorityConCtn[con[0]]--;
                result += con[1];
            }
        }
        System.out.println(result);
    }

    private static boolean checkLowPriorityCtn(int curConPriority, int[] pConCtn){
        boolean check = true;
        for(int i = curConPriority + 1; i < pConCtn.length; i++) {
            if(pConCtn[i] != 0){
                return false;
            }
        }
        return check;
    }
}
