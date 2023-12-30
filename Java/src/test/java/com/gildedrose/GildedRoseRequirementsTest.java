package com.gildedrose;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseRequirementsTest {

    @Test
    void shouldReduceRandomItemQualityPerDaily() {
        Item[] items = new Item[]{new Item("random item", 10, 50)};

        new GildedRose(items).updateQuality();

        assertEquals(49, items[0].quality);
    }

    @Test
    void shouldReduceRandomItemLastingDaysDaily() {
        Item[] items = new Item[]{new Item("random item", 10, 50)};

        new GildedRose(items).updateQuality();

        assertEquals(9, items[0].sellIn);
    }

    @Test
    void shouldReduceRandomItemQualityTwiceAsFastAfterSellInDate() {
        Item[] items = new Item[]{new Item("random item", 0, 50)};

        new GildedRose(items).updateQuality();

        assertEquals(48, items[0].quality);
    }

    @Test
    void shouldNeverReduceItemQualityBelowZero() {
        Item[] items = new Item[]{
            new Item("random item", 1, 0),
            new Item("random item", 0, 1),
            new Item("random item", 0, 0),
            new Item(Items.AGED_BRIE, 0, 0),
            new Item(Items.SULFURAS, 0, 0),
            new Item(Items.BACKSTAGE_PASSES, 0, 0)
        };

        new GildedRose(items).updateQuality();

        assertTrue(Stream.of(items).noneMatch(item -> item.quality < 0));
    }

    @Test
    void shouldIncreaseAgedBriesQuality() {
        Item[] items = new Item[]{new Item(Items.AGED_BRIE, 10, 0)};

        new GildedRose(items).updateQuality();

        assertEquals(1, items[0].quality);
    }

    @Test
    void shouldNeverIncreaseQualityAbove50() {
        Item[] items = new Item[]{new Item(Items.AGED_BRIE, 10, 50)};

        new GildedRose(items).updateQuality();

        assertEquals(50, items[0].quality);
    }


    @Test
    void shouldNeverImpactSulfuras() {
        Item[] items = new Item[]{new Item(Items.SULFURAS, 10, 50)};

        new GildedRose(items).updateQuality();

        assertEquals(10, items[0].sellIn);
        assertEquals(50, items[0].quality);
    }

    @Test
    void shouldIncreaseBackstagePassQuality_anyDateBeforeSellDate() {
        Item[] items = new Item[]{
            new Item(Items.BACKSTAGE_PASSES, 1, 1),
            new Item(Items.BACKSTAGE_PASSES, 7, 1),
            new Item(Items.BACKSTAGE_PASSES, 15, 1)
        };

        new GildedRose(items).updateQuality();

        assertTrue(Stream.of(items).allMatch(item -> item.quality > 1));
    }

    @Test
    void shouldIncreaseBackstagePassQuality_moreThan10Days_byOne() {
        Item[] items = new Item[]{new Item(Items.BACKSTAGE_PASSES, 15, 0)};

        new GildedRose(items).updateQuality();

        assertEquals(1, items[0].quality);
    }

    @Test
    void shouldIncreaseBackstagePassQuality_lessOrEqualTenButMoreThanFiveDays_byTwo() {
        Item[] items = new Item[]{
            new Item(Items.BACKSTAGE_PASSES, 10, 0),
            new Item(Items.BACKSTAGE_PASSES, 6, 0)
        };

        new GildedRose(items).updateQuality();

        assertTrue(Stream.of(items).allMatch(item -> item.quality == 2));
    }

    @Test
    void shouldIncreaseBackstagePassQuality_lessOrEqualFiveDays_byThree() {
        Item[] items = new Item[]{
            new Item(Items.BACKSTAGE_PASSES, 5, 0),
            new Item(Items.BACKSTAGE_PASSES, 1, 0)
        };

        new GildedRose(items).updateQuality();

        assertTrue(Stream.of(items).allMatch(item -> item.quality == 3));
    }


    @Test
    void shouldDropBackstagePassQualityToZeroAfterSellDate() {
        Item[] items = new Item[]{new Item(Items.BACKSTAGE_PASSES, 0, 50)};

        new GildedRose(items).updateQuality();

        assertEquals(0, items[0].quality);
    }
}
