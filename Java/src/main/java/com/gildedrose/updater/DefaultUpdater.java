package com.gildedrose.updater;

import com.gildedrose.Quality;

final class DefaultUpdater extends BoundedUpdater {
    protected int calculateQuality(int quality, int factor) {
        return quality > Quality.MIN
            ? quality - factor
            : quality;
    }
}
