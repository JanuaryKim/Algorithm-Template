package baekjoon.sort_정렬;

import java.util.Scanner;

/** 템플릿화 (삽입정렬) **/

/** 성공 : Insertion Sort **/
public class B2750 {
    public static void main(String[] args) {

        //입력
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        //~입력

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] result = insertionSort(arr); //솔루션

        //출력
        for (int i = 0; i <  result.length; i++) {
            System.out.println(result[i]);
        }
        //~출력

    }

    public static int[] insertionSort(int[] arr) {

        int index = 1; //이동되는 인덱스, 맨 앞에 요소 하나가 정렬되어있다는 가정하에 시작하므로 1부터

        while (index < arr.length) { //배열 범위내까지

            for (int i = index - 1; i >= 0; --i) { //index가 지정 됬을때마다 돌게되는 범위 (정렬되어 있다는 가정하에 앞 요소들 검사)

                if (arr[i] > arr[index]) { //이동되는 인덱스의 요소(i번째) 보다 큰것의 요소 발견순간, (발견된 순간 바꿔야하는건 확정이다)

                    int temp = arr[index]; //삽입될 요소 미리 저장, 한칸씩 뒤로 밀릴때, 가장먼저 밀려서 값이 사라지기 때문에 저장.

                    int j = i; //한칸씩 밀리는 범위를 구하기 위한 변수, 정렬됨을 가정한 요소들중 한칸 밀림 당하지 않아도 되는 요소가 있기때문에,

                    //큰 요소는 일단 발견됬는데, 앞의 요소들 중 큰 요소들이 더 있을 수 있기 때문에, 더 탐색해야함.
                    for (; j >= 0; --j) { //앞 요소로 전진

                        if (arr[j] < arr[index]) { //요소 중에 작은것이 발견된 경우, 앞 요소들은 j요소보다 다 클것이기 때문에 정지.
                            break;
                        }
                    }

                    //한칸씩 뒤로 보내야하는 요소의 경계 결정
                    if(j < 0) j = 0; //정렬됬다고 가정한 앞 요소들이 모두 arr[index]의 값보다 큰 경우, j는 위 반복문에서 -1이 된 상태로 나올 것이기에
                    else ++j; //정렬됬다고 가정한 앞 요소 중 작은것이 발견 된 경우, 작은 요소위치 + 1 이 밀리여하는 범위이다.


                    //한칸씩 뒤로 보내기
                    for (int z = index-1; z >= j; --z) {
                        arr[z+1] = arr[z];

                    }
                    arr[j] = temp; //기억해뒀던 정렬 가정했던 범위의 바로 다음요소를 삽입되어야 하는 위치에 삽입.
                    break;
                }
            }
            index++; //이동되는 인덱스 증가
        }

        return arr;
    }
}
