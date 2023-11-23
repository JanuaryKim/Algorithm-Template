import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.*;
import java.util.Arrays;
 
 
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        n = Integer.parseInt(br.readLine());
 
        int m = Integer.parseInt(br.readLine());
 
        long left = 1;
        long right = m;
 
        while(left<right){
            long mid = (left+right)/2;
            if(solve(mid)>=m){
                right=mid;
            }
            else{
                left = mid+1;
            }
        }
        System.out.println(left);
    }
    private static long solve(long mid){
        long count=0;
 
        for(int i=1; i<=n; i++){
            count+=Math.min(mid/i,n);
        }
        return count;
    }
}