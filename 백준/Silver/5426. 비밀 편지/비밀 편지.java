import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i = 0; i < n; i++) {
			String line = bf.readLine();
			//전체 길이 구하기
			//제곱근 구하기
			//반복문: i = 제곱근, i가 0보다 크거나 같을때까지
			//	반복문: j = i, i < 문자열 길이, j + 제곱근
			//		해당 위치의 문자 sb에 추가
			//	~ 반복 종료
			//~ 반복 종료
			
			int totLength = line.length();
			int sqrt = (int) Math.sqrt(totLength);
			for(int j = sqrt-1; j >= 0; j--) {
				for(int z = j; z < totLength; z+= sqrt) {
					sb.append(line.charAt(z));
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
