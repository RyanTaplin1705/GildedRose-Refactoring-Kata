package com.gildedrose;

import com.gildedrose.model.Item;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    public static final int MIN_QUALITY = 0;
    public static final int MAX_QUALITY = 50;

    public static final String REGULAR_ITEM_STRING = "Regular Item";
    public static final String AGED_BRIE_STRING = "Aged Brie";
    public static final String ANY_ITEM = "";
    public static final String SULFURAS_HAND_OF_RAGNAROS_STRING = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING = "Backstage passes to a TAFKAL80ETC concert";

    @Test
    public void itemQualityIsNeverLessThanZero() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(ANY_ITEM, 0, MIN_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isGreaterThanOrEqualTo(MIN_QUALITY);
    }

    @Test
    public void itemQualityDoesNotExceedFifty() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(ANY_ITEM, 0, MAX_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isLessThanOrEqualTo(MAX_QUALITY);
    }

    @Test
    public void regularItemQualityReducesByTwoWhenSellInIsZeroOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(REGULAR_ITEM_STRING, 0, 50));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(48);
    }

    @Test
    public void agedBrieIncreasesInQuality() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(AGED_BRIE_STRING, 5, 0));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(1);
    }

    @Test
    public void agedBrieQualityIncreasesByTwoWhenSellInIsLessThanZero() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(AGED_BRIE_STRING, 0, 0));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(2);
    }

    @Test
    public void sulfurasQualityDoesNotChange() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(SULFURAS_HAND_OF_RAGNAROS_STRING, 0, MAX_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(MAX_QUALITY);
    }

    @Test
    public void sulfurasSellInDoesNotChange() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(SULFURAS_HAND_OF_RAGNAROS_STRING, 999, MAX_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].sellIn).isEqualTo(999);
    }

    @Test
    public void backStagePassQualityIncreasesByTwoWhenSellInIsGreaterThanFive() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 10, 5));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(7);
    }

    @Test
    public void backStagePassQualityIncreasesByThreeWhenSellInIsFiveOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 5, 10));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(13);
    }

    @Test
    public void backStagePassQualityIsZeroWhenSellInIsZeroOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Item(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 0, 0));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(0);
    }

    private GildedRose givenOurAppHasItems(Item... items) {
        return new GildedRose(items);
    }

    private void whenWeUpdateProducts(GildedRose gildedRose) {
        gildedRose.updateQuality();
    }
}