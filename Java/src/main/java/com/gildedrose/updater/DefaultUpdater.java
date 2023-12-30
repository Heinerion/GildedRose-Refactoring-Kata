package com.gildedrose.updater;

import com.gildedrose.Item;

final class DefaultUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        if (item.isAgedBrie()
            || item.isBackstagePasses()) {
            if (quality < 50) {
                quality = quality + 1;

                if (item.isBackstagePasses()) {
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
            }
        } else {
            if (quality > 0) {
                if (item.isSulfuras()) {
                    return quality;
                }

                quality = quality - 1;
            }
        }
        return quality;
    }
}
