package com.gildedrose;

/* Een eerste optimalisatie van de bestaande code
/* KM
*/

class GildedRoseA1 {
    Item[] items;
    static final int MAX_Q = 50;
    static final int MIN_Q = 0;

    public GildedRoseA1(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                if (item.name.equals("Aged Brie")
                         ||item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = addTo(item.quality, 1 ,MAX_Q);
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (item.sellIn < 11) {item.quality = addTo(item.quality, 1 , MAX_Q);}
                        if (item.sellIn < 6) {item.quality = addTo(item.quality, 1 , MAX_Q);}
                    }
                } else {
                    item.quality = minOf(item.quality,1,MIN_Q);
                    if (item.name.equals("Conjured Mana Cake")) {
                            item.quality = minOf(item.quality,1,MIN_Q);
                    }
                } 
                item.sellIn = minOf(item.sellIn,1,null);
                if (item.sellIn < 0) {
                    switch (item.name) {
                        case "Backstage passes to a TAFKAL80ETC concert":
                            item.quality = MIN_Q;
                            break;
                        case "Aged Brie":
                            item.quality = addTo(item.quality, 1,MAX_Q);
                            break;
                        case "Conjured Mana Cake":
                            item.quality = minOf(item.quality, 1,MIN_Q);
                        default : 
                            item.quality = minOf(item.quality,1, MIN_Q);
                    }
                }
            }
        }
    }

    private int addTo(int inItem, int amount, Integer maxValue) {
        int outItem = inItem + amount;
        if (maxValue==null) {
            return outItem;
        }
        return outItem<maxValue?outItem:maxValue;
    }


    private int minOf(int inItem, int amount, Integer minValue) {
        int outItem = inItem - amount;
        if (minValue==null) {
            return outItem;
        }
        return outItem<minValue?minValue:outItem;
    }
}