import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String longStr = "";
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(checkEnd(bf.readLine())){
        }
        System.out.println(longStr);
    }

    private static boolean checkEnd(String line){
        boolean check = true;
        String[] words = line.split(" ");

        for(int i = 0; i < words.length; i++){
            String[] realWord = words[i].toLowerCase().split("[^a-z-]");
            for(String s : realWord){
                if(s.equals("e-n-d")){
                    return false;
                }
                if(s.length() > longStr.length()) longStr = s;
            }
        }
        return check;
    }
}
