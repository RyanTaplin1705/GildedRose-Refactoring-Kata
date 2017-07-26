package com.gildedrose.item;

public class Sulfuras extends AbstractItem {

    public Sulfuras(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();
        validateQuality();
    }

    public void increaseQuality() {
        // can't increase quality.
    }

    public void decreaseQuality() {
        // can't decrease quality.
    }

    public boolean canSellInDecrease() {
        return false;
    }
}
