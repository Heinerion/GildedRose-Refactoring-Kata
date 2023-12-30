package com.gildedrose.updater;

import com.gildedrose.Item;

final class BrieUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        if (quality < 50) {
            quality = quality + 1;
        }
        return quality;
    }
}
