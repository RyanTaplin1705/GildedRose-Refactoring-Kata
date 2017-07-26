package com.gildedrose;

import com.gildedrose.item.*;
import org.junit.Test;

import static com.gildedrose.ItemNames.*;
import static org.assertj.core.api.Assertions.*;

public class GildedRoseTest {

    @Test
    public void regularItemQualityDecreasesByOneWhenSellInIsGreaterThanZero() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new RegularItem(REGULAR_ITEM_STRING, 5, 10));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(9);
    }

    @Test
    public void itemSellInDecreases() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new RegularItem(REGULAR_ITEM_STRING, 0, 50));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].sellIn).isEqualTo(-1);
    }

    @Test
    public void regularItemQualityReducesByTwoWhenSellInIsZeroOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new RegularItem(REGULAR_ITEM_STRING, 0, 50));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(48);
    }

    @Test
    public void agedBrieIncreasesInQuality() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new AgedBrie(AGED_BRIE_STRING, 5, 0));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(1);
    }

    @Test
    public void agedBrieQualityIncreasesByTwoWhenSellInIsLessThanZero() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new AgedBrie(AGED_BRIE_STRING, 0, 0));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(2);
    }

    @Test
    public void sulfurasQualityDoesNotChange() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Sulfuras(SULFURAS_HAND_OF_RAGNAROS_STRING, 0, Sulfuras.MAXIMUM_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(Sulfuras.MAXIMUM_QUALITY);
    }

    @Test
    public void sulfurasSellInDoesNotChange() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new Sulfuras(SULFURAS_HAND_OF_RAGNAROS_STRING, 999, Sulfuras.MAXIMUM_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].sellIn).isEqualTo(999);
    }

    @Test
    public void backStagePassQualityIncreasesByTwoWhenSellInIsTenOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new BackStagePass(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 10, 5));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(7);
    }

    @Test
    public void backStagePassQualityIncreasesByThreeWhenSellInIsFiveOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new BackStagePass(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 5, 10));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(13);
    }

    @Test
    public void backStagePassQualityIsZeroWhenSellInIsZeroOrLess() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new BackStagePass(BACKSTAGE_PASSES_TO_A_TAFKAL80_ETC_CONCERT_STRING, 0, 0));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isEqualTo(0);
    }

    @Test
    public void itemQualityIsNeverLessThanZero() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new RegularItem(REGULAR_ITEM_STRING, 0, RegularItem.MINIMUM_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isGreaterThanOrEqualTo(RegularItem.MINIMUM_QUALITY);
    }

    @Test
    public void itemQualityDoesNotExceedFifty() throws Exception {
        GildedRose gildedRose = givenOurAppHasItems(new RegularItem(REGULAR_ITEM_STRING, 0, RegularItem.MAXIMUM_QUALITY));
        whenWeUpdateProducts(gildedRose);
        assertThat(gildedRose.items[0].quality).isLessThanOrEqualTo(RegularItem.MAXIMUM_QUALITY);
    }

    private GildedRose givenOurAppHasItems(AbstractItem... items) {
        return new GildedRose(items);
    }

    private void whenWeUpdateProducts(GildedRose gildedRose) {
        gildedRose.updateQuality();
    }
}