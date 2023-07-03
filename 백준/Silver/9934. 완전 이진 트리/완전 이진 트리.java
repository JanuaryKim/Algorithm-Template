import java.util.*;
import java.io.*;

public class Main {
	static int K; 
	static int[] arr; 
	static List<ArrayList<Integer>> list; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder(); 

		arr = new int[(int)Math.pow(2, K)-1]; 

		for(int i=0; i<arr.length; i++) arr[i] = Integer.parseInt(st.nextToken());
	   
		list = new ArrayList<>();
		for(int i=0; i<K; i++) list.add(new ArrayList<>()); 
		
		dfs(0, arr.length-1, 0);
		
		for(int i=0; i<K; i++) {
			for(int j : list.get(i)) sb.append(j).append(" ");
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void dfs(int start, int end, int depth) {

		if(depth == K) return;

		int middle = (start + end) / 2;

		list.get(depth).add(arr[middle]);

		dfs(start, middle-1,depth+1);

		dfs(middle+1, end, depth+1);
	}
}