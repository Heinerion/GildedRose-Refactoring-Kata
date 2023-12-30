package com.gildedrose.updater;

import com.gildedrose.Item;

final class BrieUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        return quality < 50
            ? quality + 1
            : quality;
    }
}
