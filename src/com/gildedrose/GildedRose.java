package com.gildedrose;

import com.gildedrose.model.Item;

import static com.gildedrose.ItemQuality.decreaseItemQuality;
import static com.gildedrose.ItemQuality.increaseItemQuality;
import static com.gildedrose.ItemSellIn.attemptAtDecreasingSellIn;
import static com.gildedrose.ItemSellIn.isExpired;
import static com.gildedrose.ItemValidation.isAgedBrie;
import static com.gildedrose.ItemValidation.isBackStagePass;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            attemptAtDecreasingSellIn(item);
            changeQuality(item);
        }
    }

    private void changeQuality(Item item) {
        if (valuesWithAge(item)) {
            increaseItemQuality(item);
        } else {
            decreaseItemQuality(item);
        }
    }

    private boolean valuesWithAge(Item item) {
        return isAgedBrie(item) || (isBackStagePass(item) && !isExpired(item));
    }
}