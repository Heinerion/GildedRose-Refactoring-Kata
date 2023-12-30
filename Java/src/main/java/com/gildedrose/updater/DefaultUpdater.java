package com.gildedrose.updater;

import com.gildedrose.Quality;

final class DefaultUpdater implements ItemUpdater {
    public int determineNewQuality(int quality, int sellIn) {
        return quality > Quality.MIN
            ? quality - 1
            : quality;
    }

    @Override
    public int reduceSellIn(int sellIn) {
        return sellIn - 1;
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        if (sellIn >= 0) {
            return quality;
        }

        return determineNewQuality(quality, sellIn);
    }
}
