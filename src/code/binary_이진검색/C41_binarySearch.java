package code.binary_이진검색;

/** 해결 : 템플릿 저장 **/
public class C41_binarySearch {
    public static void main(String[] args) {
        int output = C41_Solution.binarySearch(new int[]{0, 1, 2, 3, 4, 5, 6}, 2);
        System.out.println(output); // --> 2

        output = C41_Solution.binarySearch(new int[]{4, 5, 6, 9}, 100);
        System.out.println(output); // --> -1
    }
}


class C41_Solution {
    static int binarySearch(int[] arr, int target) {
        // TODO:

        int start = 0;
        int end = arr.length - 1;

        while(start <= end)
        {
            int middle = (start + end) / 2;

            if(arr[middle] == target)
                return middle;

            if(arr[middle] > target)
                end = middle - 1;
            else
                start = middle + 1;
        }
        return -1;
    }


}