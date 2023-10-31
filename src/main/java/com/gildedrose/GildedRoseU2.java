package com.gildedrose;

public class GildedRoseU2 {
    Item[] items;
    int maxQuality = 50;
    int minQuality = 0;
    int defaultAmount = 1;

    public GildedRoseU2(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            } else {
                items[i].sellIn = minOf(items[i].sellIn,this.defaultAmount,null);
                Boolean sellOut = items[i].sellIn < 0;
                if (items[i].name.equals("Aged Brie")) {
                    items[i].quality = addTo(items[i].quality,this.defaultAmount,this.maxQuality);
                    if (sellOut) {
                        items[i].quality = addTo(items[i].quality,this.defaultAmount,this.maxQuality);
                    }
                } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellOut) {
                        items[i].quality = this.minQuality;
                    } else {
                        items[i].quality = addTo(items[i].quality,this.defaultAmount,this.maxQuality);
                        if (items[i].sellIn < 11) {
                            items[i].quality = addTo(items[i].quality,this.defaultAmount,this.maxQuality);
                        }
                        if (items[i].sellIn < 6) {
                            items[i].quality = addTo(items[i].quality,this.defaultAmount,this.maxQuality);
                        }                        
                    }
                } else if (items[i].name.equals("Conjured Mana Cake")){
                    items[i].quality = minOf(items[i].quality,this.defaultAmount*2,this.minQuality);
                    if (sellOut) {
                        items[i].quality = minOf(items[i].quality,this.defaultAmount*2,this.minQuality);
                    }                    
                } else {
                    items[i].quality = minOf(items[i].quality,this.defaultAmount,this.minQuality);
                    if (sellOut) {
                        items[i].quality = minOf(items[i].quality,this.defaultAmount,this.minQuality);
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