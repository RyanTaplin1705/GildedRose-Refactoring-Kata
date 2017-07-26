package com.gildedrose;

import com.gildedrose.model.Item;

class GildedRose {
    Item[] items;

    public static final String REGULAR_ITEM_STRING = "Regular Item";
    public static final String AGED_BRIE_STRING = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS_STRING = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING = "Backstage passes to a TAFKAL80ETC concert";


    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for(Item item : items) {
            if (canDecreaseSellIn(item)) item.sellIn -= 1;

            if (isBackStagePass(item) && isExpired(item)) {
                item.quality = 0;
                return;
            }

            if (isAgedBrie(item) || isBackStagePass(item)) {
                increaseItemQuality(item);
            } else {
                decreaseItemQuality(item);
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 1;
    }

    private void increaseItemQuality(Item item) {
        if (item.quality < 50 && canDecreaseQuality(item))
            item.quality += calculateQualityIncrease(item);
    }

    private int calculateQualityIncrease(Item item) {
        if (isBackStagePass(item) && item.sellIn < 6) return 3;
        if ((isBackStagePass(item) && item.sellIn < 11) || (isAgedBrie(item) && item.sellIn < 0)) return 2;
        return 1;
    }

    private void decreaseItemQuality(Item item) {
        if (item.quality > 0 && canDecreaseQuality(item))
            item.quality -= calculateQualityDecrease(item);
    }

    private int calculateQualityDecrease(Item item) {
        if (isExpired(item)) return 2;
        return 1;
    }

    private boolean canDecreaseQuality(Item item) {
        return !isSulfuras(item);
    }

    private boolean canDecreaseSellIn(Item item) {
        return !isSulfuras(item);
    }

    private boolean isBackStagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING);
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS_STRING);
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE_STRING);
    }
}