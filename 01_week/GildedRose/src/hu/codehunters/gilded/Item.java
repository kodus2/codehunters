package hu.codehunters.gilded;

public class Item {

	private String name;
	private int quality;
	private int sellIn;

	public void increaseQuality(int addedQuality) {
		quality = quality + addedQuality;
	}

	public void decreaseQuality(int minusQuality) {
		quality = quality - minusQuality;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuality() {
		return quality;
	}

	public void setQuality(int quality) {
		this.quality = quality;
	}

	public int getSellIn() {
		return sellIn;
	}

	public void setSellIn(int sellIn) {
		this.sellIn = sellIn;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Item item))
			return false;

		if (getQuality() != item.getQuality())
			return false;
		if (getSellIn() != item.getSellIn())
			return false;
		return getName().equals(item.getName());
	}

	@Override
	public int hashCode() {
		int result = getName().hashCode();
		result = 31 * result + getQuality();
		result = 31 * result + getSellIn();
		return result;
	}

	@Override
	public String toString() {
		return "Item{" + "name='" + name + '\'' + ", quality=" + quality + ", sellIn=" + sellIn + '}';
	}
}
