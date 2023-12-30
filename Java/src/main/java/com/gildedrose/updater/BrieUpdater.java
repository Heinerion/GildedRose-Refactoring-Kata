package com.gildedrose.updater;

import com.gildedrose.Item;

final class BrieUpdater implements ItemUpdater {
    private final DefaultUpdater defaultUpdater = new DefaultUpdater();

    public int determineNewQuality(Item item) {
        int quality = item.quality;
        return quality < 50
            ? quality + 1
            : quality;
    }

    @Override
    public int reduceSellIn(Item item) {
        return defaultUpdater.reduceSellIn(item);
    }
}
