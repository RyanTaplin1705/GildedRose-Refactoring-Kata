package com.gildedrose.item;

public class BackStagePass extends AbstractItem {

    public BackStagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        decreaseSellIn();

        if (sellIn < 0) decreaseQuality();
        else increaseQuality();

        validateQuality();
    }

    public void increaseQuality() {
        if (canQualityIncrease()) return;

        if (sellIn < 6) quality += 3;
        else if (sellIn < 11) quality += 2;
        else quality += 1;
    }

    public void decreaseQuality() {
        if (canQualityDecrease()) quality = 0;
    }

    public boolean canQualityDecrease() {
        return false;
    }

    public boolean canQualityIncrease() {
        return false;
    }

    public boolean canSellInDecrease() {
        return true;
    }
}
