import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        List<Integer> list = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            int capacity = Integer.parseInt(bf.readLine());
            list.add(capacity);
            set.add(capacity);
        }

        int tempMaxContinueCnt = 0;
        for(Integer num : set){
            List<Integer> copyList = new LinkedList<>(list);
            List<Integer> removeNum = new LinkedList<>();
            removeNum.add(num);
            copyList.removeAll(removeNum);
            if(copyList.size() == 0) continue;
            int preCapacity = copyList.get(0);
            int continueCnt = 1;

            for(int i = 1; i < copyList.size(); i++){
                if(copyList.get(i).equals(preCapacity)) {
                    continueCnt++;
                }
                else{
                    if(tempMaxContinueCnt < continueCnt) tempMaxContinueCnt = continueCnt;
                    preCapacity = copyList.get(i);
                    continueCnt = 1;
                }
            }
            if(tempMaxContinueCnt < continueCnt) tempMaxContinueCnt = continueCnt;
        }

        result = tempMaxContinueCnt == 0 ? 1 : tempMaxContinueCnt;
        System.out.println(result);
    }
}
