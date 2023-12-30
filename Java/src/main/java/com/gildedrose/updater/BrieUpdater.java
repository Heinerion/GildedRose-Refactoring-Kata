package com.gildedrose.updater;

final class BrieUpdater implements ItemUpdater {
    private final DefaultUpdater defaultUpdater = new DefaultUpdater();

    public int determineNewQuality(int quality, int sellIn) {
        return quality < 50
            ? quality + 1
            : quality;
    }

    @Override
    public int reduceSellIn(int sellIn) {
        return defaultUpdater.reduceSellIn(sellIn);
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        if (sellIn >= 0) {
            return quality;
        }

        if (quality < 50) {
            return quality + 1;
        }
        return quality;
    }
}
