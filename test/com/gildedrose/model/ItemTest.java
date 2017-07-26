package com.gildedrose.model;

import com.gildedrose.model.Item;
import org.junit.Ignore;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ItemTest {

    public static final Item REGULAR_ITEM = new Item("Regular Item", 5, 10);

    @Test
    public void itemReturnsCorrectName() throws Exception {
        assertThat(REGULAR_ITEM.name).isEqualTo("Regular Item");
    }

    @Test
    public void itemReturnsCorrectQuality() throws Exception {
        assertThat(REGULAR_ITEM.quality).isEqualTo(10);
    }

    @Test
    public void itemReturnsCorrectSellIn() throws Exception {
        assertThat(REGULAR_ITEM.sellIn).isEqualTo(5);
    }

    @Test
    public void itemToStringIsCorrectFormat() throws Exception {
        assertThat(REGULAR_ITEM.toString()).isEqualTo("Regular Item, 5, 10");
    }

    //TODO: Fix the implementation of item (breaks Kata rule)
    @Ignore
    @Test
    public void itemCantHaveQualityMoreThanFifty() throws Exception {
        Item item = new Item("", 0, 999);
        assertThat(item.quality).isLessThanOrEqualTo(50);
    }

    //TODO: Fix the implementation of item (breaks Kata rule)
    @Ignore
    @Test
    public void itemCantHaveQualityLessThanZero() throws Exception {
        Item item = new Item("", 0, -1);
        assertThat(item.quality).isGreaterThanOrEqualTo(0);
    }
}