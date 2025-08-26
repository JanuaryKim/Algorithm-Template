import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {

        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNM = br.readLine().split(" ");
        int n = Integer.parseInt(strNM[0]);
        int m = Integer.parseInt(strNM[1]);
        
        List<Integer> aList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt) // String → Integer 변환
                .collect(Collectors.toList()); 

        List<Integer> bList = Arrays.stream(br.readLine().split(" "))
                .map(Integer::parseInt) // String → Integer 변환
                .collect(Collectors.toList()); 

        Collections.sort(aList, (a,b) -> b - a);
        Collections.sort(bList, (a,b) -> b - a);

        Queue<Integer> aHoleQ = new LinkedList<>(aList);
        Queue<Integer> bHoleQ = new LinkedList<>(bList);

        while(true){

            int aHole = aHoleQ.poll();

            for(int i = 0; i < aHole; i++){
                if(bHoleQ.isEmpty()) break;
                result += bHoleQ.poll();
            }

            if(aHoleQ.isEmpty() || bHoleQ.isEmpty())
                break;
            else
                result--;
        }

        System.out.println(result);
    }
}
