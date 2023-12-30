package com.gildedrose.updater;

import com.gildedrose.Item;

final class BackstagePassUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        if (quality < 50) {
            quality = quality + 1;

            if (item.sellIn < 11) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
        return quality;
    }
}
