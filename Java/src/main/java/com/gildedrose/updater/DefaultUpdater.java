package com.gildedrose.updater;

import com.gildedrose.Item;

final class DefaultUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        return quality > 0
            ? quality - 1
            : quality;
    }

    @Override
    public int reduceSellIn(Item item) {
        return item.sellIn - 1;
    }
}
