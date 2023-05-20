import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.StringTokenizer;

public class Main {
	static int a; 
	static int b; 
	static TreeSet<Integer> set;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		set = new TreeSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < a; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < b; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (set.contains(n))
				set.remove(n);
		}
		
		System.out.println(set.size());
		for(int n : set)
            System.out.print(n + " ");
	}
}