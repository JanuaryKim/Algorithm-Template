package baekjoon.queue_큐;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;


/** 성공, 20201008 **/
public class B1966_프린터_큐 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int testCaseCtn = scanner.nextInt();
        TestCase[] testCase = new TestCase[testCaseCtn];


        for (int i = 0; i < testCaseCtn; i++) {
            int n = scanner.nextInt();
            int findIndex = scanner.nextInt();

            Queue priorityQueue = new LinkedList();
            Queue indexQueue = new LinkedList();


            for (int j = 0; j < n; j++) {
                priorityQueue.add(scanner.nextInt());
                indexQueue.add(j);
            }

            testCase[i] = new TestCase(priorityQueue, indexQueue, findIndex);
        }

        solution(testCase);

    }

    public static void solution(TestCase[] testCases) {

        int[] result = new int[testCases.length];

        //테스트 케이스 하나씩 처리
        for (int i = 0; i < testCases.length; i++) {

            TestCase testCase = testCases[i];
            int printCtn = 0;

            //우선 반복문으로 들어감
            while (true) {

                //큐에서 일단 꺼냄
                int curPriority = (int)testCase.priorityQueue.poll();
                int curInitIndex = (int)testCase.indexQueue.poll();

                //꺼낸 문서보다 우선순위가 높은 문서가 있는지 검사
                boolean bigger = testCase.priorityQueue.stream().anyMatch(priority -> (int) priority > curPriority);

                if (!bigger) { //더 높은 우선순위 없다면 그대로 큐에서 나가서 출력됨
                    printCtn++; //출력이 됬을 때만 출력횟수 증가

                    if(testCase.findIndex == curInitIndex) //이번에 출력한 문서가 찾던 위치의 문서인가
                        break;
                }
                else //우선 순위 더 높은게 있어서 이번 출력 대상이 아니므로 큐 뒤로 보냄
                {
                    testCase.priorityQueue.add(curPriority);
                    testCase.indexQueue.add(curInitIndex);
                }

            }

            result[i] = printCtn;
        }

        //출력
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        //~출력

    }
}

class TestCase{

    Queue priorityQueue;
    Queue indexQueue;
    int findIndex;

    public TestCase(Queue priorityQueue, Queue indexQueue, int findIndex) {
        this.priorityQueue = priorityQueue;
        this.indexQueue = indexQueue;
        this.findIndex = findIndex;
    }
}
