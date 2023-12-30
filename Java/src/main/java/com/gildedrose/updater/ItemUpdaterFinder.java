package com.gildedrose.updater;

import com.gildedrose.Item;

public final class ItemUpdaterFinder {
    public static ItemUpdater forItem(Item item) {
        if (item.isAgedBrie()) {
            return new BrieUpdater();
        }
        if (item.isBackstagePasses()) {
            return new BackstagePassUpdater();
        }
        return new DefaultUpdater();
    }
}
