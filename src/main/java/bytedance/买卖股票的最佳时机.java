package bytedance;

public class 买卖股票的最佳时机 {

    public int maxProfit(int[] prices) {

        int min = prices[0], max = 0;

        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max, prices[i] - min);
            min = Math.max(min, prices[i]);
        }

        return max;
    }
}
