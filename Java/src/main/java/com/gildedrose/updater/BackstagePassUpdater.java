package com.gildedrose.updater;

final class BackstagePassUpdater implements ItemUpdater {
    private final DefaultUpdater defaultUpdater = new DefaultUpdater();

    public int determineNewQuality(int quality, int sellIn) {
        if (quality >= 50) {
            return quality;
        }

        return quality + determineQualityBonus(quality, sellIn);
    }

    private static int determineQualityBonus(int quality, int sellIn) {
        int bonus = 1;

        if (sellIn < 11
            && quality + bonus < 50) {
            bonus++;
        }

        if (sellIn < 6
            && quality + bonus < 50) {
            bonus++;
        }

        return bonus;
    }

    @Override
    public int reduceSellIn(int sellIn) {
        return defaultUpdater.reduceSellIn(sellIn);
    }

    @Override
    public int determineQualityBySellIn(int quality, int sellIn) {
        return sellIn >= 0
            ? quality
            : 0;
    }
}
