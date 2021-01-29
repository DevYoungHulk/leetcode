package dynamic;

import org.junit.Assert;
import org.junit.Test;

public class N115_DistinctSubsequences {
    @Test
    public void N115_DistinctSubsequences() {
        Assert.assertEquals(numDistinct("rabbbit", "rabbit"), 3);
        Assert.assertEquals(numDistinct("babgbag", "bag"), 5);
    }

    public int numDistinct(String s, String t) {
        int[][] dp = new int[t.length() + 1][s.length() + 1];
        for (int y = 0; y < s.length() + 1; y++) dp[0][y] = 1;
        for (int i = 1; i < t.length() + 1; i++) {
            for (int j = 1; j < s.length() + 1; j++) {
                if (t.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
                else dp[i][j] = dp[i][j - 1];
            }
        }
        return dp[t.length()][s.length()];
    }
}