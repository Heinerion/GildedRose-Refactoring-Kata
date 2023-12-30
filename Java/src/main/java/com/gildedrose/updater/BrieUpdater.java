package com.gildedrose.updater;

import com.gildedrose.Quality;

final class BrieUpdater implements ItemUpdater {
    private final DefaultUpdater defaultUpdater = new DefaultUpdater();

    public int determineNewQuality(int quality, int sellIn) {
        return quality < Quality.MAX
            ? quality + 1
            : quality;
    }

    @Override
    public int determineSellInDecrease() {
        return defaultUpdater.determineSellInDecrease();
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        if (sellIn >= 0) {
            return quality;
        }

        return determineNewQuality(quality, sellIn);
    }
}
