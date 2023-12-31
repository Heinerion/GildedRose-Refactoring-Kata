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
        item.sellIn -= updater.determineSellInDecrease();
        item.quality = updater.determineQuality(item.quality, item.sellIn);
    }
}
