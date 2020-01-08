package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void introduces_an_item_with_zero_everything() {
        Item[] items = new Item[] {Item.createItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void ensures_standard_product_quality_decreases_by_one_if_sellIn_is_greater_than_zero() {
        Item[] items = new Item[] {Item.createItem("foo", 10, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void ensures_quality_decreases_by_one_if_sellIn_is_greater_than_zero() {
        Item[] items = new Item[] {Item.createItem("foo", 1, 3)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    void ensures_standard_product_quality_decreases_by_two_if_sellIn_is_zero() {
        Item[] items = new Item[] {Item.createItem("foo", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void ensures_standard_product_quality_cannot_drop_below_zero(){
        Item[] items = new Item[] {Item.createItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ensures_standard_product_sellIn_decreases_by_one(){
        Item[] items = new Item[] {Item.createItem("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }

    @Test
    void ensures_Sulfuras_quality_never_changes(){
        Item[] items = new Item[] {Item.createItem("Sulfuras, Hand of Ragnaros",0,80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void ensures_Sulfuras_sellIn_never_changes(){
        Item[] items = new Item[] {Item.createItem("Sulfuras, Hand of Ragnaros",0,80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    void ensures_Sulfuras_sellIn_never_changes_when_sellIn_is_less_than_zero(){
        Item[] items = new Item[] {Item.createItem("Sulfuras, Hand of Ragnaros",-3,80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-3, app.items[0].sellIn);
    }
    @Test
    void ensures_Aged_Brie_quality_increases_2_if_sellIn_is_less_than_1(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", 0,20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(22,app.items[0].quality);
    }

    @Test
    void ensures_Aged_Brie_quality_increases_1_if_sellIn_is_greater_than_0(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", 10,20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(21,app.items[0].quality);
    }

    @Test
    void ensures_Aged_Brie_quality_remains_if_sellIn_is_less_than_zero_and_quality_over_49(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", -2,50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50,app.items[0].quality);
    }


    @Test
    void ensures_Aged_Brie_quality_remains_when_quality_over_49() {
        Item[] items = new Item[] {Item.createItem("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void ensures_Aged_Brie_sellIn_decreases_1(){
        Item[] items = new Item[] {Item.createItem("Aged Brie", 10,20)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9,app.items[0].sellIn);
    }

    @Test
    void ensures_backstagePass_quality_grows_one_when_sellIn_greater_than_10(){
        Item[] items = new Item [] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 11, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_grows_two_when_sellIn_is_greater_than_5_and_less_than_11(){
        Item[] items = new Item [] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_grows_3_when_sellIn_is_greater_than_0_and_less_than_6(){
        Item[] items = new Item [] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_grows_2_when_sellIn_is_greater_than_0_and_less_than_6(){
        Item[] items = new Item [] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 6, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_decreases_to_0_when_sellIn_is_less_than_1(){
        Item[] items = new Item [] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_remains_when_quality_over_49_and_sellIn_less_than_11_and_greater_than_5() {
        Item[] items = new Item[] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 10, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_remains_when_quality_over_49_and_sellIn_less_than_6() {
        Item[] items = new Item[] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void ensures_backstagePass_quality_grows_two_when_sellIn_less_than_6(){
        Item[] items = new Item [] {Item.createItem("Backstage passes to a TAFKAL80ETC concert", 5, 48)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
}