package com.gildedrose;

class GildedRose1 {
    Item[] items;

    public GildedRose1(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            } else {
                items[i].sellIn = minOf(items[i].sellIn,1,null);
                Boolean sellOut = items[i].sellIn < 0;
                if (items[i].name.equals("Aged Brie")) {
                    items[i].quality = addTo(items[i].quality,1,50);
                    if (sellOut) {
                        items[i].quality = addTo(items[i].quality,1,50);
                    }
                } else if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (sellOut) {
                        items[i].quality = 0;
                    } else {
                        items[i].quality = addTo(items[i].quality,1,50);
                        if (items[i].sellIn < 11) {
                            items[i].quality = addTo(items[i].quality,1,50);
                        }
                        if (items[i].sellIn < 6) {
                            items[i].quality = addTo(items[i].quality,1,50);
                        }                        
                    }
                } else {
                    
                }
            }

            if (!items[i].name.equals("Aged Brie")
                    && !items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                if (items[i].quality > 0) {
                    if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                        items[i].quality = items[i].quality - 1;
                        if (items[i].name.equals("Conjured Mana Cake") && items[i].quality > 0) {
                            items[i].quality--;
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;

                    if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].sellIn < 11) {
                            items[i].quality = addTo(items[i].quality,1,50);
                        }
                        if (items[i].sellIn < 6) {
                            items[i].quality = addTo(items[i].quality,1,50);
                        }
                    }
                }
            }

            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                                if (items[i].name.equals("Conjured Mana Cake") && items[i].quality > 0) {
                                    items[i].quality--;
                                }
                            }
                        }
                    } else {
                        items[i].quality = 0;
                    }
                } else {
                    items[i].quality = addTo(items[i].quality,1,50);
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
        return outItem>minValue?minValue:outItem;
    }
}