package com.gildedrose.item;

public interface Item {

    void update();

    void increaseQuality();
    void decreaseQuality();
    void decreaseSellIn();

//    boolean canQualityDecrease();
//    boolean canQualityIncrease();
    boolean canSellInDecrease();

    String toString();
}
