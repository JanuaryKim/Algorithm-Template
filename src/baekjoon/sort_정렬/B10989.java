package baekjoon.sort_정렬;

import java.util.Arrays;
import java.util.Scanner;

/** 퀵정렬, 정렬은 되는것 같지만 백준 2750, 2751, 10989 모두 실패.. **/
public class B10989 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input;

        int n = scanner.nextInt();
        input = new int[n];

        for (int i = 0; i < n; i++) {
            input[i] = scanner.nextInt();
        }

        quickSort(input, 0, input.length - 1);

        System.out.println(Arrays.toString(input));
    }

    private static void quickSort(int[] arr, int left, int right) {

        if (left < right) {

            int pivot = partitioning(arr, left, right);
            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    private static int partitioning(int[] arr, int left, int right) {

        int middle = (left + right) / 2;


        //중간 위치에 갑과 right 위치에 갑이 swap
        //즉, right 위치에 pivot의 값이 들어감
        int temp = arr[right];
        arr[right] = arr[middle];
        arr[middle] = temp;

        int smallIdx = left;
        int bigIdx = right - 1;
        boolean smallFix = false;
        boolean bigFix = false;

        while (smallIdx <= bigIdx) { //두개의 인덱스가 겹쳐지지 않느다면 반복

//            레퍼런스 참조하던 원래 소스, 제대로 작동하지 않는다
//            // smallIdx 위치에 값이 right 위치에 있는 피봇의 값보다 작다면 계속 인덱스 증가시킴. 만약 right 위치의 값을 제외하고 모두 작을 경우에도 smallIdx가 right 위치에 오면 arr[smallIdx]와 arr[right]의 값이 같아지므로 break됨
//            while(arr[smallIdx] < arr[right]) {
//                smallIdx++;
//            }
//
//            // bigIdx 위치에 right에 있는 피봇의 값보다 크다면 계속 인덱스 감소시킴. 만약 right 위치의 값보다 나머지 위치의 값들이 모두 작을 경우 -1이 될 수 있기때문에 조건 추가
//            while(bigIdx >= 0 && arr[bigIdx] > arr[right]) bigIdx--;


            //bigIdx가 한칸도 이동하지 않은 상태라면 바꿔선 안된다
//            if(arr[right] != arr[smallIdx])
//            {
//                temp = arr[smallIdx];
//                arr[smallIdx] = arr[bigIdx];
//                arr[bigIdx] = temp;
//            }

            if(arr[smallIdx] > arr[right])
                smallFix = true;

            if(arr[bigIdx] < arr[right])
                bigFix = true;


            if(!smallFix)
                smallIdx++;
            if(!bigFix)
                bigIdx--;

            if (smallFix && bigFix) {
                temp = arr[smallIdx];
                arr[smallIdx] = arr[bigIdx];
                arr[bigIdx] = temp;

                smallFix = false;
                bigFix = false;
                smallIdx++;
                bigIdx--;
            }
        }

        //bigIdx와 smallIdx가 겹쳐지고 나서 겹쳐진 smallIdx와 right를 바꿔서
        //피봇값을 실제 피봇 위치에 넣어준다.
        //핵심은 smallIdx와 실제 피봇값인 right를 바꾸는 것이다.\
        //bigIdx와 smallIdx가 겹쳐지는 순간에 smallIdx위치에 값은 이미 피봇 값보다
        //크기 때문에 가장 오른쪽에 있는 피봇값과 바꾸기에 잘못됨이 없다.
        temp = arr[right];
        arr[right] = arr[smallIdx];
        arr[smallIdx] = temp;

        return smallIdx;
    }


}
