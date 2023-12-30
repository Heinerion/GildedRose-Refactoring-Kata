package com.gildedrose.updater;

import com.gildedrose.*;

public final class ItemUpdaterFinder {
    public static ItemUpdater forItem(Item item) {
        if (Items.isAgedBrie(item)) {
            return new BrieUpdater();
        }
        if (Items.isBackstagePasses(item)) {
            return new BackstagePassUpdater();
        }
        if (Items.isSulfuras(item)) {
            return new SulfurasUpdater();
        }
        return new DefaultUpdater();
    }
}
