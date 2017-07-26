package com.gildedrose.item;

public class AgedBrie extends AbstractItem {

    public AgedBrie(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();
        increaseQuality();
        validateQuality();
    }

    public void increaseQuality() {
        if (sellIn < 0) quality += 2;
        else quality += 1;
    }

    public void decreaseQuality() {
        // can't decrease quality.
    }

    public boolean canSellInDecrease() {
        return true;
    }
}
