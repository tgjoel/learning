package coding.dp;

public class CoinChange {
    /* How many ways can we make the change, for the given coins and for the amount
     */
    public static void main(String[] args) {
        int[] coins = {1, 2, 3}; //  am: 4 -- 4
        //int[] coins = {1, 2, 5}; // am : 5  -- 4
       // int[] coins = {2}; //am: 4 -- 0
        int amount = 4;
        System.out.println(countNoOfWays(coins, amount));
        System.out.println(change(amount, coins));
    }


    // Time complexity: O(M*N), where M = amount, N = coins.length
    // Space complexity: O(M*N)
    private static int countNoOfWays(int[] coins, int amount) {
         int m = coins.length;

        int[][] arr = new int[m+1][amount+1];
        for (int i = 0; i <=m ; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1; i <= m ; i++) {
            int coin = coins[i -1]; // since our array has one row and column extra for no coin cases.
            for (int j = 1; j <=amount ; j++) {
                if(coin > j) {   // if the coin value is greater than the current amount, then use the above row value;
                    arr[i][j] = arr[i-1][j];
                } else { // else add the above row value with the index obtained by
                    // subtract the current amount with the current coin and the get the corresponding value at that index
                    arr[i][j] = arr[i-1][j] + arr[i][j - coin];
                }
            }
        }
        return arr[m][amount]; // ans will be at the last row for each of the amount
    }

    // Time complexity: O(M*N), where M = amount, N = coins.length
    // Space complexity: O(M)
    public static int change(int amount, int[] coins) {
        final int N = coins.length;
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 1; i <= N; i++) {
            int coin = coins[i-1];
            for (int j = 1; j <= amount; j++) {
                if (j >= coin) {
                    dp[j] += dp[j-coin];
                }
            }
        }
        return dp[amount];
    }
}
