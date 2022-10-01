package hu.codehunters.gilded;

import static hu.codehunters.gilded.QualifiedNames.*;

class GildedRose {

    public GildedRose(Item... items) {
        this.items = items;
    }

    private Item[] items;
    private static final int QUALITY_THRESHOLD = 50;

    public void updateQuality() {
        for (Item item : items) {
            if (isQualityReducibleBasedOnNameAndQuality(item)) {
                item.setQuality(item.getQuality() - 1);
            } else {
                increaseQuality(item);
            }
            updateSellIn(item);
            if (item.getSellIn() < 0 && isQualityReducibleBasedOnNameAndQuality(item)) {
                item.setQuality(item.getQuality() - 1);
            }
        }
    }

    private boolean isQualityReducibleBasedOnNameAndQuality(Item item) {
        String itemName = item.getName();
        return !AGED_BRIE.equals(itemName) && !TAFKAL80ETC.equals(
                itemName) && item.getQuality() > 0 && !SULFURAS.equals(itemName);
    }

    private void increaseQuality(Item item) {
        int itemSellIn = item.getSellIn();
        if (item.getQuality() < QUALITY_THRESHOLD) {
            item.setQuality(item.getQuality() + 1);
            if (TAFKAL80ETC.equals(item.getName()) && itemSellIn < 11 && item.getQuality() < QUALITY_THRESHOLD) {
                item.setQuality(item.getQuality() + 1);
                if (itemSellIn < 6 && item.getQuality() < QUALITY_THRESHOLD) {
                    item.setQuality(item.getQuality() + 1);
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if (!SULFURAS.equals(item.getName())) {
            item.setSellIn(item.getSellIn() - 1);
        }
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }
}