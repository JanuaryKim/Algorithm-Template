package code.sort_정렬;

import java.util.Arrays;

/** 성공 : 템플릿 저장 **/
public class C36_insertionSort {
    public static void main(String[] args) {
        int[] output = C36_Solution.insertionSort_1(new int[]{3, 1, 21});
        System.out.println(Arrays.toString(output)); // --> [1, 3, 21]
        output = C36_Solution.insertionSort_1(new int[]{5,4,3,2,1});
        System.out.println(Arrays.toString(output)); // --> [1,2,3,4,5]
    }
}

class C36_Solution {

    /** 요소의 중복이 없는 배열의 삽입 정렬 **/
    /** 배열의 맨앞에 한개의 요소(0번째)는 정렬이 됬다는 가정으로 시작해서
     *  1번째 요소부터 정렬이 되어 있다고 가정하는 앞 부분배열에 삽입할 위치는 찾는 구조.
     * **/
    public static int[] insertionSort_1(int[] arr) {

        //0번째는 정렬이 되어 있다는 가정으로 시작하므로, 삽입할 요소는 1부터이다.
        int insertTargetIdx = 1;

        //배열의 끝 요소까지 삽입을 하기위 해 끝 요소까지 반복
        while(insertTargetIdx < arr.length)
        {
            //삽입될 위치 찾기, 삽입할 요소의 이전 요소들을 순회하며 삽입 대상이 되는 요소 (삽입할 요소 보다 큰 요소) 를 찾는다.
            for(int i = 0; i <= insertTargetIdx; i++)
            {
                //정렬 됬다고 가정한 앞에 요소들 중에 삽입할 값보다 큰것을 발견
                if(arr[i] > arr[insertTargetIdx])
                {
                    //해당 조건문안에서 해야할 처리
                    // 1. 삽입 할 위치 ~ 삽입 될 요소의 이전 위치까지 의 요소들을 한칸씩 뒤로 swap 시킨다.
                    // 2. 삽입 될 요소를 삽입할 위치에 삽입한다.

                    //옮겨야할 값을 저장
                    int swapValue = arr[i];

                    //한 칸씩 뒤로 보냄
                    for(int j = i; j < insertTargetIdx; j++)
                    {
                        //다음 요소의 값을 임시 기억,
                        int temp = arr[j + 1];

                        //다음 요소 위치에 옮겨야할 값을 저장
                        arr[j + 1] = swapValue;

                        //옮겨야할 값에 임시 저장했던 다음 요소 저장.
                        swapValue = temp;
                    }

                    //마지막으로 기억한 옮겨야할 값은, 삽입 차례였던 요소이다.
                    //그러므로, 삽입 차례였던 요소를 삽입 위치에 넣어 준다.
                    arr[i] = swapValue;
                    break;
                }
            }

            //한 차례의 삽입이 끝났으므로, 다음 차례의 삽입 요소로 인덱스 증가
            insertTargetIdx++;
        }

        return arr;
    }
}

