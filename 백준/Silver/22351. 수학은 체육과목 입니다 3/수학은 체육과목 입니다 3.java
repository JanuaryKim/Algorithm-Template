import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for(int i = 1; i < 1000; i++){
            String start = String.valueOf(i);
            String end = "";
            if(line.startsWith(start)){
                String tempLine = line;
                boolean check = true;
                for(int j = i; j < 1000; j++){
                    String curNumStr = String.valueOf(j);

                    if(tempLine.startsWith(curNumStr)){
                        tempLine = tempLine.substring(curNumStr.length());
                        end = curNumStr;
                    }
                    else if(tempLine.equals("")){
                        break;
                    }
                    else{
                        check =false;
                        break;
                    }
                }
                if(check){
                    System.out.println(start + " " + end);
                    return;
                }
            }
        }
    }
}