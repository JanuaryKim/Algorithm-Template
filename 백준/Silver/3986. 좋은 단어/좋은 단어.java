import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		Stack<Character> stack = new Stack<Character>();
		int goodWords = 0;

		for(int i=0; i<N; i++) {
			String str = scan.next();
			for(int j=0; j<str.length(); j++) {
				if(!stack.isEmpty() && str.charAt(j) == stack.peek()) 
					stack.pop();	
				else 
					stack.push(str.charAt(j));	
			}
			
			if(stack.size() == 0)
				goodWords ++;

			stack.clear();	
		}

		System.out.println(goodWords);
		scan.close();
	}

}

