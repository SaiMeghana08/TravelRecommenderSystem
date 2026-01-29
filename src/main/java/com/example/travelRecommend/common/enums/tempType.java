package com.example.travelRecommend.common.enums;

public enum tempType {
    VERY_COLD(-10, 5),
    COLD(6, 15),
    MODERATE(16, 25),
    WARM(26, 32),
    HOT(33, 50);

    private final int min;
    private final int max;

    tempType(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public boolean matches(int value) {
        return value >= min && value <= max;
    }

    public int midPoint() {
        return (min + max) / 2;
    }
}
