package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.Ignore;
import org.junit.Test;

import static com.gildedrose.ItemNames.*;
import static com.gildedrose.ItemQuality.decreaseItemQuality;
import static com.gildedrose.ItemQuality.increaseItemQuality;
import static org.assertj.core.api.Assertions.*;

public class ItemQualityTest {

    @Test
    public void itemQualityDoesNotIncreasePastMaximum() throws Exception {
        Item item = new Item(AGED_BRIE_STRING, 0, 50);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    public void increaseRegularItemQualityBy1() throws Exception {
        Item item = new Item(REGULAR_ITEM_STRING, 10, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    public void increaseAgedBrieQualityBy1() throws Exception {
        Item item = new Item(AGED_BRIE_STRING, 5, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    public void increaseAgedBrieQualityBy2WhenItemIsHasLessThan0SellIn() throws Exception {
        Item item = new Item(AGED_BRIE_STRING, -1, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    public void increaseBackStagePassQualityBy1WhenItemHasMoreThan10SellIn() throws Exception {
        Item item = new Item(AGED_BRIE_STRING, 11, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    public void increaseBackStagePassQualityBy2WhenItemIsHasLessThan10SellIn() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 10, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    public void increaseBackStagePassQualityBy3WhenItemIsHasLessThan5SellIn() throws Exception {
        Item item = new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 5, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(8);
    }

    // TODO unsure if this is actually suppose to increase
    @Ignore
    @Test
    public void qualityDoesNotChangeForSulfuras() throws Exception {
        Item item = new Item(SULFURAS_HAND_OF_RAGNAROS_STRING, 5, 5);
        whenIncreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(5);
    }

    @Test
    public void itemQualityDoesNotDecreasePastMinimum() throws Exception {
        Item item = new Item(REGULAR_ITEM_STRING, 0, 0);
        whenDecreasingItemQuality(item);
        assertThat(item.quality).isEqualTo(0);
    }

    //TODO tests for decreasing quality

    private void whenDecreasingItemQuality(Item item) {
        decreaseItemQuality(item);
    }

    private void whenIncreasingItemQuality(Item item) {
        increaseItemQuality(item);
    }

}