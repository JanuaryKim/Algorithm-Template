import java.util.*;
class Solution {
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