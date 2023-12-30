package com.gildedrose.updater;

final class SulfurnasUpdater implements ItemUpdater {
    public int determineNewQuality(int quality, int sellIn) {
        return quality;
    }

    @Override
    public int reduceSellIn(int sellIn) {
        return sellIn;
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        return quality;
    }
}
