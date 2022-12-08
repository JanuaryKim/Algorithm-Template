package programmers.hash_해시.P_전화번호목록;


import java.util.HashMap;
import java.util.LinkedHashMap;


/** 성공 **/
public class P_전화번호목록 {

    public static void main(String[] args) {


        Solution solution = new Solution();

//        System.out.println(solution.solution(new String[]{"117", "114", "2481","1147910"})); //false
        System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421"})); //false
        System.out.println(solution.solution(new String[]{"123","456","789"})); //true
        System.out.println(solution.solution(new String[]{"12","123","1235","567","88"})); //false
    }

    static class Solution {
        public boolean solution(String[] phone_book) {

            HashMap<String, String> hashMap = new LinkedHashMap<>();

            for (int i = 0; i < phone_book.length; i++) {
                hashMap.put(phone_book[i], phone_book[i]);
            }

            for (String key : hashMap.keySet()) {
                String phone = hashMap.get(key);

                for (int j = 0; j < phone.length(); j++) {

                    if (hashMap.get(phone.substring(0, j)) != null) {
                        return false;
                    }
                }
            }

            return true;

        }
    }
}
