package baekjoon.sort_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/** 구현 완료 **/
public class QuickSort {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        quickSort(arr, 0, n-1);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(i-> sb.append(i + "\n"));
        System.out.println(sb);
    }



    static void quickSort(int[] arr, int start, int end) {

        if(start >= end)
            return;

        int middle = arr[(start + end) / 2];

        int left = start;
        int right = end;

        while (left <= right) { //=조건이 없으면 left와 right가 겹쳐진 이후로 계속 quickSort 무한호출에 빠짐
            while(arr[left] < middle) left++;
            while(arr[right] > middle) right--;

            if (left <= right) { //=조건이 없으면 left와 right가 겹쳐진 이후로 계속 quickSort 무한호출에 빠짐
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, left, end);
    }
}
