package com.example.travelRecommend.common.enums;

public enum budgetType {
    LOW(0, 30000),
    MEDIUM(30001, 70000),
    HIGH(70001, 150000),
    LUXURY(150001, Integer.MAX_VALUE);

    private final int min;
    private final int max;

    budgetType(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean matches(int amount) {
        return amount >= min && amount <= max;
    }

    public int average() {
        return max == Integer.MAX_VALUE ? min : (min + max) / 2;
    }
}
