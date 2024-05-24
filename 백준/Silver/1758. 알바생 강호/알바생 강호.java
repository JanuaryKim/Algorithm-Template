import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(arr, Comparator.reverseOrder());
		
		long result = 0;
		for(int i=0;i<N;i++) {
			int temp = arr[i]-i;
			if(temp<0) break;
			result += temp;
		}
		
		bw.write(result+"");
		bw.flush();
		bw.close();
			
	}
}