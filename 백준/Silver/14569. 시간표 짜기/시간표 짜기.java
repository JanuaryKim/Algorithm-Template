import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Integer>[] classArr = new List[n]; //과목 시간표 리스트
        for(int i = 0; i < n; i++){
            int[] arr =Arrays.stream(bf.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).toArray();
            classArr[i] = new ArrayList<>();
            for(int j = 1; j < arr.length; j++){
                classArr[i].add(arr[j]);
            }
        }

        int m = Integer.parseInt(bf.readLine());
        int[] result = new int[m];
        boolean[][] students = new boolean[m][]; //각 학생별 공강 테이블
        for(int i = 0; i < m; i++){
            int[] time = Arrays.stream(bf.readLine().split(" ")).mapToInt(s->Integer.parseInt(s)).toArray();
            students[i] = new boolean[51];
            for(int j = 1; j < time.length; j++){
                students[i][time[j]] = true;
            }
        }

        for(int i = 0; i < m; i++){
            for(List<Integer> sub : classArr){
                boolean isOk = true;
                for(int j = 0; j < sub.size(); j++){
                    if(!students[i][sub.get(j)]) {
                        isOk = false;
                        break;
                    }
                }
                if(isOk) result[i]++;
            }
        }
        IntStream.range(0, result.length).forEach(i-> System.out.println(result[i]));
    }
}
