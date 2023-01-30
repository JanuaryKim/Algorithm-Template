import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Integer[] card = new Integer[n];
        int total = 0;

        for (int i = 0; i < n; i++) {
            card[i] = scanner.nextInt();
        }

        int result = 0;

        // 3개를 고르기 때문에 첫번째 카드는 N - 2 까지만 순회
        for (int i = 0; i < n - 2; i++) {

            // 두 번째 카드는 첫 번째 카드 다음부터 N - 1 까지만 순회
            for (int j = i + 1; j < n - 1; j++) {

                // 세 번째 카드는 두 번째 카드 다음부터 N 까지 순회
                for (int k = j + 1; k < n; k++) {

                    // 3개 카드의 합 변수 temp
                    int temp = card[i] + card[j] + card[k];

                    // M과 세 카드의 합이 같다면 temp return 및 종료
                    if (m == temp) {
                        System.out.println(temp);
                        return;
                    }

                    // 세 카드의 합이 이전 합보다 크면서 M 보다 작을 경우 result 갱신
                    if(result < temp && temp < m) {
                        result = temp;
                    }
                }
            }
        }
        System.out.println(result);
    }


}