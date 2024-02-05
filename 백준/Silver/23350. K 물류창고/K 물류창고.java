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
        //수도코드
        //현재 쌓아야할 우선순위에 맞지 않는 우선순위가 나타나면 레일 처음으로 보냄 /
        //현재 우선순위 보다 낮은 컨테이너 무조건 적재 /
        //현재 우선순위와 같은 컨테이너이면서
        //  만약 무게가 작다면
        //      그대로 쌓음
        //  만약 무게가 더 나간다면
        //      무게가 더 작게 나가거나 같은 컨테이너가 나올때까지 이미 쌓은 컨테이너를 치워둔다.
        //  만약 무게가 같다면
        //      그대로 쌓음
        //
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] splLine = bf.readLine().split(" ");
        int n = Integer.parseInt(splLine[0]);
        int m = Integer.parseInt(splLine[1]);
        int curM = m; //현재 쌓아야할 우선순위 값(각 우선순위당 최소 1개는 존재하기 때문에)
        int[] priorityConCtn = new int[m+1]; //각 우선순위당 컨테이너 갯수 체크 배열
        Queue<int[]> q = new LinkedList<>(); //컨테이너가 올려져 있는 레일 역할의 큐
        Stack<int[]> s = new Stack<>(); //컨테이너가 쌓아지는 스택
        for(int i = 0; i < n; i++){ //초기화
            splLine = bf.readLine().split(" ");
            int priority = Integer.parseInt(splLine[0]);
            int weight = Integer.parseInt(splLine[1]);
            int[] container = new int[]{priority, weight};
            priorityConCtn[priority]++; //우선순위별 컨테이너 갯수 체크
            q.add(container); //레일에 적재
        }
        while(!q.isEmpty()){ //레일에 컨테이너가 존재 하지 않을때까지
            int[] con = q.poll(); //이번에 내릴 컨테이너
            if(con[0] < curM){ //현재 쌓아야할 우선순위 보다 높은경우
                if(checkLowPriorityCtn(con[0], priorityConCtn)){
                    s.add(con);
                    priorityConCtn[con[0]]--;
                    curM--;
                } else{
                    q.add(con);
                }
                result += con[1];
            } else if (con[0] == curM) { // 현재 쌓아야할 우선순위와 같은 경우
                if(!s.isEmpty() && s.peek()[1] < con[1]) //꺼내져 쌓인 컨테이너가 더 무겁다면
                {
                    Stack<int[]> tempS = new Stack<>();
                    while(!s.isEmpty() && s.peek()[0] == con[0] && s.peek()[1] < con[1]){ //우선순위가 같으면서 가벼운 것들을 따로 빼둠
                        int[] tempCon = s.pop();
                        tempS.push(tempCon);
                        result += tempCon[1];
                    }
                    s.push(con);
                    priorityConCtn[con[0]]--;
                    result += con[1];

                    while(!tempS.isEmpty()){ //따로 빼둔 컨테이너 다시 원래대로 쌓아둠
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
            } else { //현재 쌓아야할 우선순위 보다 작은 경우
                s.push(con);
                priorityConCtn[con[0]]--;
                result += con[1];
            }
        }
        System.out.println(result);
    }
    //컨테이너가 스택에 쌓아져 있는데, 이번에 내리는 컨테이너 보다 낮은 우선순위의 컨테이너들이 스택에 모두 쌓였느지 체크 함수
    private static boolean checkLowPriorityCtn(int curConPriority, int[] pConCtn){
        boolean check = true;
        for(int i = curConPriority + 1; i < pConCtn.length; i++) { //레일에서 이번에 내릴 컨테이너 보다 낮은 우선순위의 컨테이너가 레일에 남아있는가 체크 
            if(pConCtn[i] != 0){
                return false;
            }
        }
        return check;
    }
}
