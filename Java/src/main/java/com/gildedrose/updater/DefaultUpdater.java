package com.gildedrose.updater;

import com.gildedrose.Item;

final class DefaultUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        if (quality > 0) {
            quality = quality - 1;
        }
        return quality;
    }
}
