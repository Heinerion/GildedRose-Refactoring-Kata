package com.gildedrose.updater;

import com.gildedrose.Quality;

final class SulfurnasUpdater implements ItemUpdater {
    public int determineNewQuality(int quality, int sellIn) {
        return Quality.SULFURAS;
    }

    @Override
    public int reduceSellIn(int sellIn) {
        return sellIn;
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        return Quality.SULFURAS;
    }
}
