package code.sort_정렬;

import static code.sort_정렬.C35_Solution.*;

/** 실패, 미완성 **/
public class C35_quickSort {
    public static void main(String[] args) {
        int[] output = quickSort(new int[]{3, 1, 21});
        System.out.println(output); // --> [1, 3, 21]
    }
}

class C35_Solution {
    public static int[] quickSort(int[] arr) {
        // TODO:

        int left = 0;
        int right = arr.length-1;
        int middle = (left + right) / 2;

        return new int[2];
    }

    private void recursion(int left, int right, int pivot, int[] arr) {

        if (left < right) {

            partitioning(left, right, pivot, arr);


        }
    }

    private int partitioning(int left, int right, int pivot, int[] arr) {

        int realRight = right; //현재 범위에서 실제로 제일 오른쪽인 인덱스 기억 해둠
        //피봇과 제일 끝에 값 swap
        //left 인덱스와 right 인덱스 이동시켜가면 swap
        int temp = arr[right];
        arr[right] = arr[pivot];
        arr[pivot] = temp;

        right--; //제일 끝으로 이동된 실제 pivot제외 하고 앞에 인덱스부터 피봇값과 비교하기위해


        while (left <= right) {
            while(arr[pivot] > arr[left] && left < right) {

                left++;
            }
            while(arr[pivot] < arr[right] && left < right) {

                if(left > right)
                    break;

                right--;
            }



            int swapTemp = arr[left];
            arr[left] = arr[right];
            arr[right] = swapTemp;

            right--;
            left++;
        }



        return 0;
    }
}
