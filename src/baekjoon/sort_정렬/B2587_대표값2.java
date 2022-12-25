package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 성공 **/
public class B2587_대표값2 {
    static int size = 5;
    static int maxValue = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        selectSort(arr);

    }

    /** 성공 **/
    private static void selectSort(int[] arr) {

        int sum = Arrays.stream(arr).sum();
        for (int i = 0; i < arr.length-1; i++) {

            int curMinIdx = i;

            for (int j = i + 1; j < arr.length; j++) {

                if (arr[curMinIdx] < arr[j]) {
                    curMinIdx = j;
                }
            }

            if (curMinIdx != i) {
                int temp = arr[curMinIdx];
                arr[curMinIdx] = arr[i];
                arr[i] = temp;
            }
        }

        System.out.println(sum / size);
        System.out.println(arr[2]);
    }



//    /** 실패 **/
//    //계수 정렬 1차
//    public static void countingSort(int[] arr) {
//        int[] countArr = new int[maxValue];
//        int sum = 0;
//
//        //카운팅 하기
//        for (int i = 0; i < size; i++) {
//            sum += arr[i];
//            countArr[arr[i]]++;
//        }
//
//        //누적합 구하기
//
//        for (int i = 1; i < maxValue; i++) {
//            countArr[i] += countArr[i-1];
//        }
//
//        int[] sortedArr = new int[size];
//        for (int i = size - 1; i >= 0; i--) {
//            int placeIdx = countArr[arr[i]]-1;
//            sortedArr[placeIdx] = arr[i];
//            countArr[arr[i]] = placeIdx;
//        }
//
//        System.out.println(sum/size);
//        System.out.println(Arrays.toString(sortedArr));
//
//
//        //요소들 중 최소, 최대 값을 구한다.
//        //최소 부터 최대 값 크기의 배열을 생성한다. (count)
//        //오리지날 배열의 각 원소를 순회하며 해당 값이 한번 증가할때마다 count 배열의 인덱스에 +1을 증가시킨다
//
//    }
}
