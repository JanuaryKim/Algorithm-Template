package programmers.heap_힙.P_더_맵게;
import java.util.PriorityQueue;

import static programmers.heap_힙.P_더_맵게.P_더_맵게_Solution.*;

public class P_더_맵게 {
    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int K = 7;


        System.out.println(solution(scoville, K));
    }
}



class P_더_맵게_Solution {
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        //------ 수도코드
        //섞은 횟수 변수 = 0;
        //우선순위 큐에 배열 요소들 넣음
        //반복문
        //현재 요소가 전부 K보다 크다면
        //반복문 탈출
        //0번째것 꺼냄 (root 노드 꺼내면 자동으로 다시 힙 구조로 정렬하여 제일 작은 값이 root 노드(0번재 요소) 로 오기 때문에)
        //0번째것 꺼냄 (root 노드 꺼내면 자동으로 다시 힙 구조로 정렬하기 제일 작은 값이 root 노드(0번재 요소) 로 오기 때문에)

        //스코빌 연산하여 결과값을 우선순위 큐에 넣음

        //~종료
        //------ ~ 수도코드

        //생성자에 정렬 기준을 인자로 넣어주지 않으면 기본적오름 차순 (최소힙) 이고, Integer는 내부적으로 비교 기준이 있다.
        PriorityQueue<Integer> queue = new PriorityQueue(); //최소힙

        //최대힙
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>((Integer o1, Integer o2) -> (- Integer.compare(o1,o2)));

        for(int scov : scoville)
        {
            queue.add(scov);
        }

        while(queue.peek() < K) //힙 구조인 우선순위큐는 큐의 정렬 기준에 따라 0번째가 요소들 중 제일 크거나, 제일 작거나 하기 때문에
        {
            if(queue.size() == 1) //이전에 제일 약한 매운맛 2개를 합쳤더니 1개만 남은 경우, 예외처리
                return -1;

            int minSco = queue.poll();
            int minSco2 = queue.poll();

            int newSco = minSco + (minSco2 * 2); //문제에서 제시한 새로은 스코빌 만드는 방법으로 새 스코빌 생성

            queue.add(newSco);
            answer++;
        }


        return answer;
    }
}