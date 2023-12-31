package com.gildedrose.updater;

import com.gildedrose.Quality;

final class BrieUpdater extends BoundedUpdater {
    protected int calculateQuality(int quality, int factor) {
        return quality < Quality.MAX
            ? quality + factor
            : quality;
    }
}
