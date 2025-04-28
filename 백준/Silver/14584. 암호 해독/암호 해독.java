import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String oriInput = bf.readLine();
        int n = Integer.parseInt(bf.readLine());
        String[] wordsArr = new String[n];

        for(int i = 0; i < n; i++){
            wordsArr[i] = bf.readLine();
        }

        for(int i = 0; i < 26; i++){
            String enStr = encrypt(oriInput, i);

//            System.out.println(enStr);
            if(checkContains(enStr, wordsArr)){
                System.out.println(enStr);
                break;
            }
        }
    }

    private static boolean checkContains(String enStr, String[] words){

        boolean result = false;

        for(String w : words){
            for(int i = 0; i <= enStr.length() - w.length(); i++){
                String subStr = enStr.substring(i, i + w.length());
                if(w.equals(subStr)){
                    result = true;
                    break;
                }
            }
        }

        return result;
    }

    private static String encrypt(String oriStr, int count){

        StringBuilder result = new StringBuilder();

//        System.out.println("카운트 : "+ count);
//        System.out.println("z값 : " + (int)'z');
        for(int i = 0; i < oriStr.length(); i++){

//            System.out.println("원문자 : " + (int)oriStr.charAt(i));
            int c = oriStr.charAt(i) + count;


//            System.out.println("수정 : " + c);
            if(c > 'z') c = 'a' + (c - 'z' - 1);
//            System.out.println("교정 : " + c);

//            System.out.println("---- ");
            result.append((char)c);
        }
        return result.toString();
    }
}
