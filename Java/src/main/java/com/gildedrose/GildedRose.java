package com.gildedrose;

import com.gildedrose.updater.ItemUpdaterFinder;

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
        item.quality = determineNewQuality(item);
        reduceSellIn(item);
        handleNegativeSellIn(item);
    }

    private static int determineNewQuality(Item item) {
        return ItemUpdaterFinder
            .forItem(item)
            .determineNewQuality(item);
    }

    private static void reduceSellIn(Item item) {
        if (item.isSulfuras()) {
            return;
        }

        item.sellIn = item.sellIn - 1;
    }

    private static void handleNegativeSellIn(Item item) {
        if (item.sellIn >= 0) {
            return;
        }

        if (item.isAgedBrie()) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
            return;
        }

        if (item.isBackstagePasses()) {
            item.quality = item.quality - item.quality;
            return;
        }

        if (item.quality > 0) {
            if (item.isSulfuras()) {
                return;
            }
            item.quality = item.quality - 1;
        }
    }
}
