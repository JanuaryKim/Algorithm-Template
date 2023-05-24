import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String line = bf.readLine();

        StringBuilder sb = new StringBuilder();
        StringBuilder notVoca = new StringBuilder();
        StringBuilder voca = new StringBuilder();

        boolean flag = false;
        for (int i = 0; i < line.length(); i++) {
            char curChar = line.charAt(i);
            if(curChar == '<')
                flag = true;

            if (flag) {

                notVoca.append(curChar);

                if (voca.length() != 0) {
                    sb.append(voca.reverse());
                    voca = new StringBuilder();
                }
                if (curChar == '>') {
                    flag = false;
                    sb.append(notVoca);
                    notVoca = new StringBuilder();
                }
            }
            else{
                if (curChar == ' ') {
                    if (voca.length() != 0) {
                        sb.append(voca.reverse());
                        voca = new StringBuilder();
                    }
                    sb.append(curChar);
                    continue;
                }

                voca.append(curChar);
            }
        }

        if (notVoca.length() != 0) {
            sb.append(notVoca);
        } else if (voca.length() != 0) {
            sb.append(voca.reverse());
        }

        System.out.println(sb);
    }
}
