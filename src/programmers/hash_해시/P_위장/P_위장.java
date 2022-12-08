package programmers.hash_해시.P_위장;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;




/** 실패 ,시간 초과, 참조 할것 : https://coding-grandpa.tistory.com/entry/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%9C%84%EC%9E%A5-%ED%95%B4%EC%8B%9C-Lv-2-%EC%9E%90%EB%B0%94-Java **/
public class P_위장 {
    public static void main(String[] args) {
        Solution solution = new Solution();


    }



    static class Solution {
        static int count = 0;

        public static int solution(String[][] clothes) {

            HashMap<String, List<String>> map = new HashMap<>();
            List<String> keyList = new ArrayList<>();

            for(int i = 0; i < clothes.length; i++)
            {
                String[] oneThing = clothes[i]; //의상 한개 가져 옴

                String kind = oneThing[1]; //의상의 종류

                List<String> list = map.get(kind);

                if(list == null)
                {
                    keyList.add(kind); // 키 저장

                    list = new ArrayList();
                    map.put(kind, list);
                }

                list.add(oneThing[0]);
            }



            int currentKeyIdx = 0;

            recursion(null, currentKeyIdx + 1, keyList, map);

            for (String item : map.get(keyList.get(currentKeyIdx))) {

                recursion(item, currentKeyIdx + 1, keyList, map);
            }

            return count - 1;
        }

        static void recursion(String selectedItem, int keyIdx, List<String> keyList, HashMap<String, List<String>> map) {

            if(keyIdx >= keyList.size())
            {
                count++;
                return;
            }

            recursion(null, keyIdx + 1, keyList, map);


            for (String item : map.get(keyList.get(keyIdx))) {

                recursion(item, keyIdx + 1, keyList, map);

            }

        }
    }





//    static class Solution {
//        static int count = 0;
//
//        public static int solution(String[][] clothes) {
//
//            HashMap<String, List<String>> map = new HashMap<>();
//            List<String> keyList = new ArrayList<>();
//
//            for(int i = 0; i < clothes.length; i++)
//            {
//                String[] oneThing = clothes[i]; //의상 한개 가져 옴
//
//                String kind = oneThing[1]; //의상의 종류
//
//                List<String> list = map.get(kind);
//
//                if(list == null)
//                {
//                    keyList.add(kind); // 키 저장
//
//                    list = new ArrayList();
//                    map.put(kind, list);
//                }
//
//                list.add(oneThing[0]);
//            }
//
//
//
//            int currentKeyIdx = 0;
//
//            recursion(null, currentKeyIdx + 1, keyList, map);
//
//            for (String item : map.get(keyList.get(currentKeyIdx))) {
//
//                recursion(item, currentKeyIdx + 1, keyList, map);
//            }
//
//            return count - 1;
//        }
//
//        static void recursion(String selectedItem, int keyIdx, List<String> keyList, HashMap<String, List<String>> map) {
//
//            if(keyIdx >= keyList.size())
//            {
//                count++;
//                return;
//            }
//
//            recursion(null, keyIdx + 1, keyList, map);
//
//
//            for (String item : map.get(keyList.get(keyIdx))) {
//
//                recursion(item, keyIdx + 1, keyList, map);
//
//            }
//
//        }
//    }
}
