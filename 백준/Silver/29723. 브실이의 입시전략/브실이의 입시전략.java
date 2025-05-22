import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        int sumMax = 0;
        int sumMin = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputStrNMK = bf.readLine().split(" ");
        int n = Integer.parseInt(inputStrNMK[0]);
        int m = Integer.parseInt(inputStrNMK[1]);
        int k = Integer.parseInt(inputStrNMK[2]);

        List<Subject> subs = new ArrayList<>();

        for(int i = 0; i < n; i++){
            String[] sub = bf.readLine().split(" ");
            subs.add(new Subject(sub[0], Integer.parseInt(sub[1])));
        }

        String[] revealSubs = new String[k];
        for(int i = 0; i < k; i++){
            revealSubs[i] = bf.readLine();
        }

        //공개된 과목 점수 추가 및 리스트에서 제거
        for(int i = 0; i < k; i++){
            String revealSubsName = revealSubs[i];

            for (int j = 0; j < subs.size(); j++) {
                if(subs.get(j).name.equals(revealSubsName)){
                    sumMax += subs.get(j).score;
                    sumMin += subs.get(j).score;
                    subs.remove(j);
                    break;
                }
            }
        }

        //정렬 - 오름차순
        Collections.sort(subs, (a, b)->{
            return a.score - b.score;
        });

        int addSubCnt = m - k;

        int maxIdx = subs.size()-1;
        int minIdx = 0;
        for(int i = 0; i < addSubCnt; i++){
            sumMax += subs.get(maxIdx--).score;
            sumMin += subs.get(minIdx++).score;
        }
        System.out.println(sumMin + " " + sumMax);

    }

    private static class Subject{
        String name;
        int score;

        public Subject(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
