package hu.codehunters.gilded;

public class Main {

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Item item1 = new Item();
		item1.setSellIn(3);
		item1.setQuality(15);
		item1.setName(QualifiedNames.TAFKAL80ETC);
		GildedRose gildedRose = new GildedRose(item1);
		gildedRose.updateQuality();
		System.out.println(item1.getQuality());
	}
}
