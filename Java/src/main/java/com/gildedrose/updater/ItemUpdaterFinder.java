package com.gildedrose.updater;

import com.gildedrose.Item;

public final class ItemUpdaterFinder {
    public static ItemUpdater forItem(Item item) {
        return new DefaultUpdater();
    }
}
