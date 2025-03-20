import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {


        String regex = "^(100|[0-9]?)$"; //1~100 사이인지
        List<String> names = new ArrayList<>();
        int n = 0;
        int[] check = new int[0];   //0 기본, 1 뺏김, 2 되찾음
        int scenario = 1;

        Pattern pattern = Pattern.compile(regex);


        while(true){
            String input = bf.readLine();
            Matcher matcher = pattern.matcher(input);
            if(matcher.matches()){ //n일 경우
                n = Integer.parseInt(input);
                if(n == 0){
                    break;
                }
                else{
                    //기존에 시나리오가 존재하였다면
                    if(names.size() > 0){
                        solve(scenario++, check, names);
                    }
                    check = new int[n];
                    names.clear();
                    for(int i = 0; i < n; i++){
                        names.add(bf.readLine());
                    }
                }
            }
            else{ //뺏긴 리스트일 경우
                String[] spl = input.split(" ");
                int num = Integer.parseInt(spl[0]);
                check[num-1]++;
            }
        }

        solve(scenario, check, names);

        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }

    public static void solve(int scenario, int[] check, List<String> names){

        StringBuffer sb = new StringBuffer();

        sb.append(scenario + " ");
        for(int i = 0; i < check.length; i++){
            if(check[i] == 1)
                sb.append(names.get(i) +" ");
        }
        result.add(sb.toString());
    }

}
