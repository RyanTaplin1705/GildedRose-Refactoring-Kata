package com.gildedrose;

import com.gildedrose.model.Item;

import static com.gildedrose.ItemNames.*;

public class ItemValidation {

    static boolean isBackStagePass(Item item) {
        return item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING);
    }

    static boolean isSulfuras(Item item) {
        return item.name.equals(SULFURAS_HAND_OF_RAGNAROS_STRING);
    }

    static boolean isAgedBrie(Item item) {
        return item.name.equals(AGED_BRIE_STRING);
    }
}
