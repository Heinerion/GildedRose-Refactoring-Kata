package com.gildedrose.updater;

public interface ItemUpdater {
    int determineNewQuality(int quality, int sellIn);

    int determineSellInDecrease();

    int determineQualityBySellIn(int quality, int sellIn);
}
