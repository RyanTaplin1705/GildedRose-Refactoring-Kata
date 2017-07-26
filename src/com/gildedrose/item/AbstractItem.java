package com.gildedrose.item;

public abstract class AbstractItem implements Item {

    public String name;
    public int sellIn;
    public int quality;

    public static int MAXIMUM_QUALITY = 50;
    public static int MINIMUM_QUALITY = 0;

    public AbstractItem(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public void decreaseSellIn() {
        if (canSellInDecrease()) sellIn -= 1;
    }

    public void validateQuality() {
        if(quality > MAXIMUM_QUALITY) quality = MAXIMUM_QUALITY;
        else if (quality < MINIMUM_QUALITY) quality = MINIMUM_QUALITY;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
