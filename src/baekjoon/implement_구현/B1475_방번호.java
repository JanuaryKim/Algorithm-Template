package baekjoon.implement_구현;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class B1475_방번호 {

    static String roomNumber;
    static List<Integer[]> sets = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        roomNumber = scanner.nextLine();

        Integer[] set = new Integer[10];
        Arrays.fill(set,0);
        sets.add(set);

        solution();
    }

    public static void solution() {

        for (int i = 0; i < roomNumber.length(); i++) {
            char c = roomNumber.charAt(i);
            Integer value = Integer.parseInt(String.valueOf(c)); //방번호 중 하나의 숫자

            int[] checkValue;

            if(value.equals(6)) //6인 경우
            {
                checkValue = new int[] {6,9};
            } else if (value.equals(9)) { //9인 경우
                checkValue = new int[] {9, 6};
            }else //나머지
            {
                checkValue = new int[]{value};
            }


            boolean find = false;
            for (int j = 0; j < sets.size(); j++) { // 번호 세트 순회
                Integer[] setList = sets.get(j);
                 find = false;

                for (int z = 0; z < checkValue.length; z++) { //체크 항목들을 리스트내에서 확인
                    if (setList[checkValue[z]].equals(1)) {
                        continue;
                    }
                    else
                    {
                        find = true;
                        setList[checkValue[z]] = 1;
                        break;
                    }
                }

                if (find) {
                    break;
                }
            }

            if (!find) {
                Integer[] newSet = new Integer[10];
                Arrays.fill(newSet,0);
                newSet[value] = 1;
                sets.add(newSet);
            }
        }
        System.out.println(sets.size());
    }
}
