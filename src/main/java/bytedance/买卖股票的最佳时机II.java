package bytedance;

public class 买卖股票的最佳时机II {

    public int maxProfit(int[] prices) {
        int ans=0;
        for(int i=1;i<=prices.length-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }
}
