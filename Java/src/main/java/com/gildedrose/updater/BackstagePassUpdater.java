package com.gildedrose.updater;

import com.gildedrose.Item;

final class BackstagePassUpdater implements ItemUpdater {
    public int determineNewQuality(Item item) {
        int quality = item.quality;
        if (quality >= 50) {
            return quality;
        }

        return quality + determineQualityBonus(quality, item.sellIn);
    }

    private static int determineQualityBonus(int quality, int sellIn) {
        int bonus = 1;

        if (sellIn < 11
            && quality + bonus < 50) {
            bonus++;
        }

        if (sellIn < 6
            && quality + bonus < 50) {
            bonus++;
        }

        return bonus;
    }
}
