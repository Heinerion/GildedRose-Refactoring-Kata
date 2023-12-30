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
        item.quality = updater.determineNewQuality(item.quality, item.sellIn);
        item.sellIn -= updater.determineSellInDecrease();
        item.quality = updater.determineQualityBySellIn(item.quality, item.sellIn);
    }
}
