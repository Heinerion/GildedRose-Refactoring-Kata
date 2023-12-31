package com.gildedrose;

public class Items {
    static final String AGED_BRIE = "Aged Brie";
    static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    static final String CONJURED_PREFIX = "Conjured";


    public static boolean isAgedBrie(Item item) {
        return Items.AGED_BRIE.equals(item.name);
    }

    public static boolean isBackstagePasses(Item item) {
        return Items.BACKSTAGE_PASSES.equals(item.name);
    }

    public static boolean isSulfuras(Item item) {
        return Items.SULFURAS.equals(item.name);
    }

    public static boolean isConjured(Item item) {
        return item.name.startsWith(CONJURED_PREFIX);
    }
}
