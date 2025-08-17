import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		String[] str = new String[N];
		for(int i=0; i<N; i++)
			str[i] = scan.next();

		for(int i=0; i<str.length-1; i++) {
			for(int j=0; j<str.length; j++) {
				StringBuilder sb2 = new StringBuilder(str[j]);
				if(str[i].equals(sb2.reverse().toString())) {
					
 					System.out.print(str[i].length() + " " + str[i].charAt(str[i].length()/2));
					return;
				}
			}
		}
		
		scan.close();
	}

}