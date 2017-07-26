package com.gildedrose;

import com.gildedrose.model.Item;
import static com.gildedrose.ItemValidation.isSulfuras;

public class ItemSellIn {

    static void attemptAtDecreasingSellIn(Item item) {
        if (canDecreaseSellIn(item)) item.sellIn -= 1;
    }

    static boolean canDecreaseSellIn(Item item) {
        return !isSulfuras(item);
    }

    static boolean isExpired(Item item) {
        return item.sellIn < 1;
    }


}
