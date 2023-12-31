package com.gildedrose.updater;

import com.gildedrose.Quality;

final class SulfurasUpdater implements ItemUpdater {
    public int determineQuality(int quality, int sellIn) {
        return Quality.SULFURAS;
    }

    @Override
    public int determineSellInDecrease() {
        return 0;
    }
}
