package com.gildedrose.updater;

public interface ItemUpdater {
    int determineQuality(int quality, int sellIn);

    int determineSellInDecrease();
}
