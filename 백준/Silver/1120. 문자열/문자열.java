import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bf.readLine().split(" ");

        String A = inputs[0];
        String B = inputs[1];


       int minDiff = Integer.MAX_VALUE;
        for(int i=0;i<B.length()-A.length()+1;i++){
            int tempDiff=0;

            for(int j=0;j<A.length();j++){
                if(A.charAt(j)!=B.charAt(j+i)){
                    tempDiff++;
                }
            }
            if(minDiff > tempDiff){
                minDiff = tempDiff;
            }
        }

        System.out.println(minDiff);


    }
}
