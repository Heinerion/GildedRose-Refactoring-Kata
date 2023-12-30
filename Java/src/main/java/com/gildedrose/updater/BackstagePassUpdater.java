package com.gildedrose.updater;

import com.gildedrose.Quality;

final class BackstagePassUpdater implements ItemUpdater {
    private static final int DOUBLE_QUALITY_DAYS = 10;
    private static final int TRIPLE_QUALITY_DAYS = 5;
    private static final int EXPIRED_DAYS = 0;

    private final DefaultUpdater defaultUpdater = new DefaultUpdater();

    public int determineNewQuality(int quality, int sellIn) {
        return Math.min(
            Quality.MAX,
            quality + determineLastMinuteBonus(sellIn));
    }

    private static int determineLastMinuteBonus(int daysLeft) {
        if (daysLeft <= TRIPLE_QUALITY_DAYS) {
            return 3;
        }

        if (daysLeft <= DOUBLE_QUALITY_DAYS) {
            return 2;
        }

        return 1;
    }

    @Override
    public int reduceSellIn(int sellIn) {
        return defaultUpdater.reduceSellIn(sellIn);
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        return sellIn >= EXPIRED_DAYS
            ? quality
            : Quality.MIN;
    }
}
