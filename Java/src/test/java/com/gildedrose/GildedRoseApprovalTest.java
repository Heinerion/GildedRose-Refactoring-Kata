package com.gildedrose;

import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GildedRoseApprovalTest {
    @Test
    public void thirtyDays() {
        Item[] items = initItems();
        GildedRose app = new GildedRose(items);
        String stats = writeStatsForDays(30, items, app);
        Approvals.verify(stats);
    }

    private static String writeStatsForDays(int days, Item[] items, GildedRose app) {
        List<String> stats = new ArrayList<>();
        stats.add("OMGHAI!");

        for (int i = 0; i < days; i++) {
            stats.add(writeStatsForDay(items, app, i));
        }
        return String.join("\n", stats);
    }

    private static String writeStatsForDay(Item[] items, GildedRose app, int i) {
        String stats = collectStats(items, i);
        app.updateQuality();
        return stats;
    }

    private static String collectStats(Item[] items, int i) {
        List<String> textLines = new ArrayList<>();
        textLines.add("-------- day " + i + " --------");
        textLines.add("name, sellIn, quality");
        for (Item item : items) {
            textLines.add(String.valueOf(item));
        }
        textLines.add("");
        return String.join("\n", textLines);
    }

    private static Item[] initItems() {
        return new Item[]{
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6)};
    }

}
