package com.gildedrose.item;

public class RegularItem extends AbstractItem {

    public RegularItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();
        decreaseQuality();
        validateQuality();
    }

    public void increaseQuality() {
        // can't increase quality.
    }

    public void decreaseQuality() {
        quality -= sellIn < 1 ? 2 : 1;
    }

    public boolean canSellInDecrease() {
        return true;
    }
}
