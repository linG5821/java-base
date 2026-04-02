package com.ling5821.javabase.fund;

import java.math.BigDecimal;

public class CostCalculator {
    // 计算补仓后的新持仓成本
    public static BigDecimal calcNewCost(BigDecimal curCost, BigDecimal curAmount, BigDecimal addAmount,
        BigDecimal addPrice) {
        return curCost.multiply(curAmount).add(addAmount.multiply(addPrice)).divide(curAmount.add(addAmount), 6,
            BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        // 当前持仓成本
        BigDecimal curCost = new BigDecimal("0.8128");
        // 当前持仓数量
        BigDecimal curAmount = new BigDecimal("3590.07");
        // 补仓价格
        BigDecimal addPrice = new BigDecimal("0.5411");
        int amount = 1;
        while (true) {
            // 补仓数量
            BigDecimal addAmount = new BigDecimal(amount);
            BigDecimal newCost = calcNewCost(curCost, curAmount, addAmount, addPrice);
            BigDecimal diffCost = curCost.subtract(newCost);
            BigDecimal addCost = addPrice.multiply(addAmount);
            BigDecimal dilutionRatio = diffCost.divide(addCost, 8, BigDecimal.ROUND_HALF_UP);
            System.out.printf("补仓后的新持仓成本为: %s 成本下降: %s 补仓金额: %s 稀释比: %s\n", newCost, diffCost, addCost, dilutionRatio);
            amount += 10;
            if (addCost.compareTo(BigDecimal.valueOf(10000)) > 0) {
                break;
            }
        }
    }
}