package Java8Samples.model;

public class PublicItem {
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getExtra() {
		return extra;
	}
	@Override
	public String toString() {
		return "PublicItem [name=" + name + ", qty=" + qty + ", extra=" + extra + "]";
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	private String name;
	private int qty;
	private String extra;
}
