package com.gildedrose;

import com.gildedrose.updater.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateQuality(item);
        }
    }

    private static void updateQuality(Item item) {
        ItemUpdater updater = ItemUpdaterFinder
            .forItem(item);
        item.quality = updater.determineNewQuality(item);
        item.sellIn = updater.reduceSellIn(item);
        item.quality = determineQualityBySellIn(item);
    }

    private static int determineQualityBySellIn(Item item) {
        int quality = item.quality;
        if (item.sellIn >= 0) {
            return quality;
        }

        if (item.isAgedBrie()) {
            if (quality < 50) {
                return quality + 1;
            }
            return quality;
        }

        if (item.isBackstagePasses()) {
            return quality - quality;
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
