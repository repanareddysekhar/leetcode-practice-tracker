class Solution {
    public int maxProfit(int[] prices) {
        if(null == prices || prices.length < 2) return 0;

        int maxProfit = Integer.MIN_VALUE;
        int minPrice = Integer.MAX_VALUE;
        
        for(int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}