import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = bf.readLine();
        String searchVoca = bf.readLine();

        int startIdx = 0;
        int maxRepeat = 0;
        while (startIdx <= inputStr.length() - searchVoca.length()) {

            String substring = inputStr.substring(startIdx, startIdx + searchVoca.length());

            if (substring.equals(searchVoca)) {
                int tempRepeat = 1;
                int tempStartIdx = startIdx + searchVoca.length();

                while (tempStartIdx <= inputStr.length() - searchVoca.length()) {

                    substring = inputStr.substring(tempStartIdx, tempStartIdx + searchVoca.length());
                    if (substring.equals(searchVoca)) {
                        tempRepeat++;
                        tempStartIdx += searchVoca.length();
                    } else {
                        tempStartIdx++;
                    }
                }

                if(tempRepeat > maxRepeat)
                    maxRepeat = tempRepeat;
            }
            startIdx++;
        }

        System.out.println(maxRepeat);

    }
}
