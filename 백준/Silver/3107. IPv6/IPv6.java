import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder result = new StringBuilder();
    static String simpleIP = "";
    static int existsGroup = 0;
    static int skipPos = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        simpleIP = br.readLine();

        skipCheck();
        zeroCheck();
        System.out.println(result);
    }

    private static void skipCheck(){
        char preChar = '-';
        skipPos = 0; //0 : 없음, 1 : 처음, 2 : 중간, 3 : 끝
        existsGroup = 0;
        boolean find = false;

        for(int i = 0; i < simpleIP.length(); i++){
            char c = simpleIP.charAt(i);
            if(preChar == ':' && c == ':' && i == 1){
                skipPos = 1;
                find = true;
            }
            else if(preChar == ':' && c == ':' && i == simpleIP.length()-1){
                skipPos = 3;
                find = true;
            }
            else if(preChar == ':' && c == ':'){
                skipPos = 2;
                find = true;
            }

            if((preChar == '-' || preChar == ':') && ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))){
                existsGroup++;
            }

            preChar = c;
        }


        if(find) {
            int needGroup = 8 - existsGroup;
            StringBuilder sb = new StringBuilder();
            if(skipPos == 1){
                addGroup(sb, needGroup);
                sb.append(":");
            }
            else if(skipPos == 2){
                sb.append(":");
                addGroup(sb, needGroup);
                sb.append(":");
            }
            else if(skipPos == 3){
                sb.append(":");
                addGroup(sb, needGroup);
            }

            simpleIP = simpleIP.replaceAll("::", sb.toString());
        }
    }

    private static void addGroup(StringBuilder sb, int needGroup){
        for(int i = 0; i < needGroup; i++){
            sb.append("0000");
            if(i != needGroup - 1) sb.append(":");
        }
    }

    private static void zeroCheck(){
        String[] splIP = simpleIP.split(":");

        for(int i = 0; i < splIP.length; i++) {
            String temp = String.format("%4s", splIP[i]);
            result.append(temp.replace(' ', '0'));
            if(i != splIP.length - 1) result.append(":");
        }
    }
}
