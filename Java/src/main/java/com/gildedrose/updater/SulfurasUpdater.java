package com.gildedrose.updater;

import com.gildedrose.Quality;

final class SulfurasUpdater implements ItemUpdater {
    public int determineNewQuality(int quality, int sellIn) {
        return Quality.SULFURAS;
    }

    @Override
    public int determineSellInDecrease() {
        return 0;
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        return Quality.SULFURAS;
    }
}
