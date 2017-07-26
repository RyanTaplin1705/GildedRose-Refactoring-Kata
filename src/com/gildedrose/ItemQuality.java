package com.gildedrose;

import com.gildedrose.model.Item;

import static com.gildedrose.ItemSellIn.isExpired;
import static com.gildedrose.ItemValidation.isAgedBrie;
import static com.gildedrose.ItemValidation.isBackStagePass;
import static com.gildedrose.ItemValidation.isSulfuras;


//TODO looks a bit messy, can be refactored more?
class ItemQuality {

    static final int MAX_QUALITY = 50;
    static final int MIN_QUALITY = 0;

    static void increaseItemQuality(Item item) {
        if (!isMaximumQuality(item.quality))
            item.quality += notHigherThanMax(item, calculateQualityIncrease(item));
    }

    static void decreaseItemQuality(Item item) {
        if (!isMinQuality(item.quality) && canDecreaseQuality(item))
            item.quality -= notLowerThanMin(item, calculateQualityDecrease(item));
    }

    private static int calculateQualityIncrease(Item item) {
        if (isBackStagePass(item) && item.sellIn < 6) return 3;
        if ((isBackStagePass(item) && item.sellIn < 11) || (isAgedBrie(item) && item.sellIn < 0)) return 2;
        return 1;
    }

    private static int calculateQualityDecrease(Item item) {
        if (isExpired(item) && isBackStagePass(item)) return MAX_QUALITY;
        if (isExpired(item)) return 2;
        return 1;
    }

    private static int notHigherThanMax(Item item, int i) {
        if (isMaximumQuality(item.quality + i)) return MAX_QUALITY - item.quality;
        else return i;
    }

    private static int notLowerThanMin(Item item, int i) {
        if (isMinQuality(item.quality - i)) return i + (item.quality - i);
        else return i;
    }

    private static boolean canDecreaseQuality(Item item) {
        return !isSulfuras(item);
    }

    private static boolean isMaximumQuality(int quality) {
        return quality > MAX_QUALITY;
    }

    private static boolean isMinQuality(int quality) {
        return quality < MIN_QUALITY;
    }
}
