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

    @Override
    public int determineQualityBySellIn(Item item) {
        int quality = item.quality;
        if (item.sellIn >= 0) {
            return quality;
        }

        if (item.quality > 0) {
            if (item.isSulfuras()) {
                return quality;
            }
            return quality - 1;
        }

        return quality;
    }
}
