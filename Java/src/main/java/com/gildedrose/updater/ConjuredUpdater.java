package com.gildedrose.updater;

import com.gildedrose.Quality;

final class ConjuredUpdater extends BoundedUpdater {
    protected int calculateQuality(int quality, int factor) {
        return quality > Quality.MIN
            ? quality - factor * 2
            : quality;
    }
}
