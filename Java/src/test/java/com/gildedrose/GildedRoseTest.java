package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void randomItemLoosesSellInPerUpdate() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, items[0].sellIn);
    }

    @Test
    void sulfurasDoesNotLooseSellInValue() {
        Item[] items = new Item[]{new Item(Items.SULFURAS, 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, items[0].sellIn);
    }

    @Test
    void brieOfPoorQualityGetsBetter() {
        Item[] items = new Item[]{new Item(Items.AGED_BRIE, 0, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void brieOfModestQualityStaysTheSame() {
        Item[] items = new Item[]{new Item(Items.AGED_BRIE, 0, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, items[0].quality);
    }

    @Test
    void brieOfHighQualityStaysTheSame() {
        Item[] items = new Item[]{new Item(Items.AGED_BRIE, 0, Quality.MAX)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(Quality.MAX, items[0].quality);
    }
}
