package com.gildedrose.updater;

import com.gildedrose.Quality;

abstract class BoundedUpdater implements ItemUpdater {
    public int determineQuality(int quality, int sellIn) {
        int agingFactor = calculateAgingFactor(sellIn);
        return Math.max(Quality.MIN, Math.min(Quality.MAX, calculateQuality(quality, agingFactor)));
    }

    protected abstract int calculateQuality(int quality, int factor);

    private static int calculateAgingFactor(int daysLeft) {
        return daysLeft >= 0 ? 1 : 2;
    }

    @Override
    public int determineSellInDecrease() {
        return 1;
    }
}
