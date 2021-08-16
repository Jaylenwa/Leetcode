package 智力题;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author WJL
 * @date: 2021/08/10 14:52
 * <p>
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 **/

public class 买卖股票的最佳时机 {

    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        买卖股票的最佳时机 tep = new 买卖股票的最佳时机();

        int i = tep.maxProfit3(prices);
        System.out.println(i);

    }

    //maxProfit2的优化 yyds  //可以理解为动态规划  从后往前存当前下标往后的最大值
    public int maxProfit3(int[] prices){
        int maxPrice = 0;
        for (int i = prices.length - 2; i >= 0 ; i--) {
            int tempValue = prices[i];
            if (prices[i] < prices[i + 1]){
                prices[i] = prices[i + 1];
            }
            if (prices[i] - tempValue > maxPrice) maxPrice = prices[i] - tempValue;
        }
        return maxPrice;
    }


    public int maxProfit2(int[] prices){
        int[] temp = Arrays.copyOf(prices,prices.length);
        int max = 0;
        for (int i = temp.length - 2; i >= 0 ; i--) {
            if (temp[i] < temp[i + 1]){
                temp[i] = temp[i + 1];
            }
            if (temp[i] - prices[i] > max) max = temp[i] - prices[i];
        }
        return max;
    }


    //超时间了
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i; j < prices.length; j++) {
               int profit = prices[j] - prices[i];
               if (profit > max) max = profit;
            }
        }
        return max;
    }
}