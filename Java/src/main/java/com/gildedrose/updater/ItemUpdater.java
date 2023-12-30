package com.gildedrose.updater;

import com.gildedrose.Item;

public interface ItemUpdater {
    int determineNewQuality(Item item);

    int reduceSellIn(Item item);

    int determineQualityBySellIn(Item item);
}
