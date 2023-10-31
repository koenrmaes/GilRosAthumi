package com.gildedrose;

/* Een volgende optimalisatie
/* KM
*/
import java.util.Arrays;
import java.util.List;

class GildedRoseA2 {
    Item[] items;
    static final int MAX_Q = 50;
    static final int MIN_Q = 0;

    public GildedRoseA2(Item[] items) {
        this.items = items;
    }

    private Item nextDay(Item it, int mod, List<Integer> days) {
        Item item = new Item(it.name,it.sellIn--,it.quality);
        if ((it.quality<=MIN_Q&&mod<0)||(it.quality>=MAX_Q&&mod>0)) {
            return item;
        } else {
            it.quality = it.quality + mod;
            for (int day : days) {
                if (it.sellIn < day) it.quality = it.quality + mod;
            }
            if (it.quality < MIN_Q) it.quality = MIN_Q;
            if (it.quality > MAX_Q) it.quality = MAX_Q;
        }
        return item;
    }

    public void updateQuality() {

        for (Item item : items) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros" : break;
                case "Backstage passes to a TAFKAL80ETC concert": 
                    if (item.sellIn < 0) {
                        item.sellIn--;
                        item.quality = MIN_Q;
                    } else {
                        item = nextDay(item,+1,Arrays.asList(10,5));
                    }
                    break;
                case "Aged Brie" : 
                    item = nextDay(item,+1,Arrays.asList(0));
                    break;
                case "Conjured Mana Cake": 
                    item = nextDay(item,-2,Arrays.asList(0));
                    break;
                default : item = nextDay(item,-1,Arrays.asList(0));
            } 
        }
    }
}