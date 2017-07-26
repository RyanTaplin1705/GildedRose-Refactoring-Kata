package com.gildedrose.item;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class ItemTest {

    public static final AbstractItem REGULAR_ITEM = new RegularItem("Regular Item", 5, 10);

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

    @Test
    public void itemCantHaveQualityMoreThanFifty() throws Exception {
        AbstractItem item = new RegularItem("", 0, 999);
        assertThat(item.quality).isLessThanOrEqualTo(50);
    }

    @Test
    public void itemCantHaveQualityLessThanZero() throws Exception {
        AbstractItem item = new RegularItem("", 0, -1);
        assertThat(item.quality).isGreaterThanOrEqualTo(0);
    }
}