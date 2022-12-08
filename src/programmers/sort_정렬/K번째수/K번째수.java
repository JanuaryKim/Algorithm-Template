package programmers.sort_정렬.K번째수;

import java.util.Arrays;

import static programmers.sort_정렬.K번째수.K번째수_Solution.*;

/** 성공, 라이브러리 사용 버전과 직접 구현 버전  **/
public class K번째수 {
    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        int[] solution = solution(array, commands);
        System.out.println(Arrays.toString(solution)); // -> [5, 6, 3]
    }
}

class K번째수_Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        //배열을 부분배열로 만듦
        //해당 배열 정렬
        //결과 배열에서 k번째 값 저장

        for(int z = 0; z < commands.length; z++)
        {
            int i = commands[z][0];
            int j = commands[z][1];
            int k = commands[z][2];

            int[] splArr = Arrays.copyOfRange(array, i-1, j); //라이브러리 사용

            //정렬
            insertSort(splArr); //삽입 정렬 직접 구현
            // Arrays.sort(splArr); //라이브러리 사용

            answer[z] = splArr[k-1];
        }


        return answer;
    }

    //삽입 정렬
    public static void insertSort(int[] splArr)
    {
        //삽입 정렬은 0번째 요소는 정렬이 된것이라고 가정하고 정렬을 시작함
        //그러므로 1번째 요소부터 앞 요소들의 위치 중 삽입 되어야 하는 위치를 찾으면 됨 (ex : 1번째 요소보다 0번째 요소가 클 경우,
        //0번째 요소는 다음칸(1번 인덱스위치)으로 한칸 밀리고, 1번째 요소가 0번째 위치에 들어감)
        //그러므로 삽입 될 요소는 1번째부터 시작

        for(int i = 1; i < splArr.length; i++) //1번째 부터
        {
            //i번째 요소가 정렬 되어 있다고 가정한 앞부분에서 어디에 들어갈지
            //앞 정렬 가정 배열을 가장 끝에서부터 순차적으로 확인한다 (i-1 번째 요소부터 0번째까지 순차적으로 검사)
            //i번째 요소보다 작은것이 발견되지 않는 경우는 앞선 요소들이 모두 i번째 요소보다 큰것일 경우,
            //작은것이 발견되면 해당 인덱스 이전 요소부터 가정 배열의 제일 끝에 요소까지 모두 한칸씩 뒤로 밀기
            //마지막에 i번째 요소의 값을 최초 밀은 인덱스에 넣음

            int preArrIdx = i - 1;

            while(splArr[i] < splArr[preArrIdx])
            {

                preArrIdx--;

                if(preArrIdx < 0)
                {
                    break;
                }
            }

//            위에 while문의 탈출 조건은 발견됬거나, 아예 안 발견 됬거나, 아니면 진입조차 안했거나
//            원래는 아래의 세가지 조건으로 분기할 수 있다.
//            그러나, else if 구문과 else 구문의 처리가 swap으로 동일하다.
//            그러므로, if문의 조건일 경우만 continue 처리하고 swap 구문은 아래에 넣어서 if문 구문에 걸리지 않을 경우에
//            처리 하도록한다.
//
//            원래 생각했던 분기문
//             if(preArrIdx == (i - 1)) //진입 조차 안한것
//             {
//                 //처리 필요 x
//                 continue;
//             }
//             else if(preArrIdx < 0) //앞에 가정 배열이 모두 i번째 보다 큰것
//             {
//
//             }
//             else //앞에 가정 배열 중에 발견된것
//             {
//
//             }


            if(preArrIdx == (i - 1)) //진입 조차 안한것
            {
                continue;
            }

            int iValue = splArr[i]; //가정 배열의 제일 끝에부터 swap 하기때문에 저장해둠

            //swap
            for(int j = i - 1; j > preArrIdx; --j)
            {
                splArr[j+1] = splArr[j];
            }

            splArr[preArrIdx + 1] = iValue;
        }
    }
}