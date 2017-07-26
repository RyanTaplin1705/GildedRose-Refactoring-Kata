package com.gildedrose;

import com.gildedrose.item.AbstractItem;
import com.gildedrose.item.Item;

class GildedRose {
    AbstractItem[] items;

    public GildedRose(AbstractItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for(Item item : items) {
            item.update();
        }
    }
}