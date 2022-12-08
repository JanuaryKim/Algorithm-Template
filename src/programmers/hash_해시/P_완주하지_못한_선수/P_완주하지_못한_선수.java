package programmers.hash_해시.P_완주하지_못한_선수;

import java.util.*;

/** 성공 **/
public class P_완주하지_못한_선수 {
    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.solution(new String[]{"leo", "kiki", "eden"},	new String[]{"eden", "kiki"}));
        System.out.println(solution.solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},	new String[]{"josipa", "filipa", "marina", "nikola"}));
        System.out.println(solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"},	new String[]{"stanko", "ana", "mislav"}));


    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {

                return participant[i];
            }
        }

        return participant[participant.length-1];

    }
}


//class Solution {
//    public String solution(String[] participant, String[] completion) {
//
//        LinkedHashMap<String, Integer> comMap = new LinkedHashMap<>();
//
//        for (String str : completion) {
//            comMap.put(str,0);
//        }
//
//        for (String str : participant) {
//
//            Integer removedValue = comMap.remove(str);
//
//            if (removedValue == null) {
//                return str;
//            }
//        }
//        return participant[participant.length-1];
//    }
//}