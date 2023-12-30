package com.gildedrose.updater;

import com.gildedrose.Item;

final class SulfurnasUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        return item.quality;
    }
}
