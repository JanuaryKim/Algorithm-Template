package code.dp_디피;

import static code.dp_디피.C46_Solution.*;

/** 성공, 전형적인 dp 문제, 동전바꾸기 **/
public class C46_coinChange {
    public static void main(String[] args) {
        int total = 10;
        int[] coins = new int[]{1, 5};
        int output = coinChange(total, coins);
        System.out.println(output); // --> 3

        total = 4;
        coins = new int[]{1, 2, 3};
        output = coinChange(total, coins);
        System.out.println(output); // --> 4 ([1, 1, 1, 1], [1, 1, 2], [2, 2], [1, 3])
    }
}

class C46_Solution {
    public static int coinChange(int total, int[] coins) {
        // TODO :

        int[] dp = new int[total+1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j < dp.length; j++) {

                if((j - coins[i]) < 0)
                    continue;

                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[total];

    }
}


