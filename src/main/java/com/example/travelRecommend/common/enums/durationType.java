package com.example.travelRecommend.common.enums;

public enum durationType {
    SHORT(1, 3),
    MEDIUM(4, 7),
    LONG(8, 14),
    EXTENDED(15, 30);

    private final int minDays;
    private final int maxDays;

    durationType(int minDays, int maxDays) {
        this.minDays = minDays;
        this.maxDays = maxDays;
    }

    public boolean matches(int days) {
        return days >= minDays && days <= maxDays;
    }

    public int averageDays() {
        return (minDays + maxDays) / 2;
    }
}
