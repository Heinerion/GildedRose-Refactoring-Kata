package com.gildedrose.updater;

public interface ItemUpdater {
    int determineNewQuality(int quality, int sellIn);

    int reduceSellIn(int sellIn);

    int determineQualityBySellIn(int quality, int sellIn);
}
