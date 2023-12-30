package com.gildedrose.updater;

import com.gildedrose.Item;

final class DefaultUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        if (quality > 0) {
            if (item.isSulfuras()) {
                return quality;
            }

            quality = quality - 1;
        }
        return quality;
    }
}
