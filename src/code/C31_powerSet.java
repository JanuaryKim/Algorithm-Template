package code;

import java.util.*;
import java.util.stream.Collectors;

import static code.C31_Solution.powerSet;

/** 성공, PowerSet(부분집합), 부분집합 템플릿 **/
/** 참조 : https://philipbox.tistory.com/11 **/
public class C31_powerSet {
    public static void main(String[] args) {
        ArrayList<String> output1 = powerSet("abc");
        System.out.println(output1); // ["", "a", "ab", "abc", "ac", "b", "bc", "c"]

        ArrayList<String> output2 = powerSet("jjump");
        System.out.println(output2); // ["", "j", "jm", "jmp", "jmpu", "jmu", "jp", "jpu", "ju", "m", "mp", "mpu", "mu", "p", "pu", "u"]


    }
}

class C31_Solution {

    public static ArrayList<String> powerSet(String str) {

        //중복된 요소를 넣지 않기 위해 만드는 과정의 컬랙션은 Set으로
        //Set을 사용하지 않으면, jjum 와 같은 문자열이 존재할 경우,
        //현재 로직에서는 첫번째 j 선택하고 두번째 j선택 안한것과, 첫번째 j 선택 안하고, 두번째 j 선택한것이 별개의 것이 되어지므로, j, j 가 들어가게 되있음
        Set<String> set = new LinkedHashSet<>();

        //recursion 메소드의 base case 에서 문자열을 만들어갈때 사전순으로 만들 수 있도록 하기 위해 애초에 문자열을 사전순으로 재 정렬,
        //만약 cba의 문자열이라면 현재 로직에서는 cba, cb, c 이런 순으로 들어갈것임.
        //결과에 요소가 되는 Set에 이미 cba 로 들어가면 Set을 sorting 한다고 하여도 cba는 하나의 요소이기에 set을 정렬하는것은 의미없음.
        //cba를 abc로 소팅을 해야 abc, ab, a 로 들어감. 그렇지 않고 그대로 cba로 두면 cba, cb, c 식의 순서로 들어감.
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String sortedStr = new String(chars);
        //~문자열 정렬

        recursion(sortedStr, 0, new boolean[sortedStr.length()], set);

        //Set 안에 요소들을 사전순으로 정렬하는것으로
        //이렇게 정렬 하지 않으면, 문자열이 jmpu일 경우, jmpu, jmp 이런식으로 모두가 선택된 순서대로 들어감
        //그래서 정렬을 해야 Set안에 요소들이 j, jm 이런식으로 정렬됨.
        List<String> sortedList = set.stream().sorted().collect(Collectors.toList()); //사전순 소팅
        return new ArrayList<>(sortedList);
    }

    private static void recursion(String str, int index, boolean[] selected, Set<String> set) {

        if (index == str.length()) { //종료조건 (base case)

            String newStr = "";
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    char addChar = str.charAt(i);
                    boolean isExistsChar = newStr.chars().anyMatch(c-> c == addChar); //이번에 문자열에 추가할 문자가 현재 문자열 내에 이미 존재하는 문자인가?

                    if(!isExistsChar) //존재하지 않을 경우에만
                        newStr += String.valueOf(addChar);
                }
            }
            set.add(newStr);
            return;
        }


        selected[index] = true; // 이번 인덱스 위치의 문자열을 선택한다
        recursion(str, index+1, selected, set);
        selected[index] = false; // 이번 인덱스 위치의 문자열을 선택 안 한다.
        recursion(str, index+1, selected, set);
    }
}

