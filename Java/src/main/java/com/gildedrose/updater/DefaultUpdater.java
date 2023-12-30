package com.gildedrose.updater;

final class DefaultUpdater implements ItemUpdater {
    public int determineNewQuality(int quality, int sellIn) {
        return quality > 0
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

        return quality > 0
            ? quality - 1
            : quality;
    }
}
