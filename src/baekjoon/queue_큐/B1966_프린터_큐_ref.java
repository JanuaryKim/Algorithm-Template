package baekjoon.queue_큐;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1966_프린터_큐_ref {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<T;i++) {

            //n(문서갯수) 과 찾으려는 인덱스 라인으로 입력 받음
            st = new StringTokenizer(br.readLine());

            //라인 파싱
            int N = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());


            //출력 대기 문서의 우선순위가 담긴 배열
            int queue[] = new int[N+1];

            //시작 인덱스. 끝 인덳스 저장
            int start = 0;
            int end = N;

            //문서 우선순위 라인으로 인력 받음
            st = new StringTokenizer(br.readLine());

            //라인으로 입력받은 우선순위 요소들 초기화 단계
            for(int j=0;j<N;j++) {
                queue[j] = Integer.parseInt(st.nextToken());
            }

            //출력순서 1부터 시작
            int result = 1;

            //배열 클론
            int com[] = queue.clone();

            //정렬함
            Arrays.sort(com);


            int temp = N;



            while(true) {
                if(queue[start] < com[temp]) {
                    queue[end] = queue[start];
                    if(start==index) {
                        index = end;
                    }
                    start = (start+1)%(N+1);
                    end = (end+1)%(N+1);
                }
                else {
                    if(start == index) {
                        sb.append(result).append("\n");
                        break;
                    }
                    result++;
                    temp--;
                    start=(start+1)%(N+1);
                }
            }
        }
        System.out.print(sb);
    }
}