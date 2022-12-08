package baekjoon.brute_force_완전탐색;

import java.util.*;

// 본 문제는 소스들의 조합으로 만들어지는 신맛 - 쓴맛 의 최소값을 구하는것이기 때문에
// 각 요소의 순서는 상관없잉 조합 문제이다.
// 그러므로 재귀함수 호출내에서 반복문을 i+1 부터 시작한다.

/** 성공 **/
public class C_도영이가_만든_맛있는_음식 {
    static int diff; // 로직을 돌며 최소 차이값이 저장되는 변수
    static Integer[][] sources; // 소스들을 담는 배열

    public static void main(String[] args) {

        // input 받는 단계
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        sources = new Integer[n][2];

        for (int i = 0; i < n; i++) {

            sources[i][0] = scanner.nextInt();
            sources[i][1] = scanner.nextInt();
        }
        // -- input 받는 단계

        diff = Math.abs(sources[0][0] - sources[0][1]); //초기화

        for (int i = 0; i < n; i++) {
            List<Integer> indexList = new ArrayList<>();
            indexList.add(i);

            int tempDiff = getDiff(indexList);
            diff = diff > tempDiff ? tempDiff : diff;

            recursion(i,indexList);
        }

        System.out.println(diff);
    }

    // 재귀적 호출을 하여 조합의 경우의 수를 구한다.
    public static void recursion(int index, List<Integer> indexList) {

        for (int i = index + 1; i < sources.length; i++) {

            ArrayList tempIndexList = new ArrayList(indexList);
            tempIndexList.add(i);

            int tempDiff = getDiff(tempIndexList);
            diff = diff > tempDiff ? tempDiff : diff;

            recursion(i, tempIndexList);
        }

    }

    // 현재까지 담겨진 소스의 신맛 - 쓴맛 의 차이값을 구한다.
    public static int getDiff(List<Integer> indexList) {

        int sin = 1;
        int ssen = 0;

        Iterator<Integer> iterator = indexList.iterator();
        while (iterator.hasNext()) {
            Integer index = iterator.next();

            sin *= sources[index][0];
            ssen += sources[index][1];
        }

        return Math.abs(sin - ssen);
    }
}


