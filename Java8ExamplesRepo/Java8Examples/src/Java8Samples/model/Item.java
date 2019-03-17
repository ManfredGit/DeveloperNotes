package Java8Samples.model;

public class Item {
	
	private String name;
    private int qty;
    private Double price;
    
    public Item(String name, int qty, Double price) {
		super();
		this.name = name;
		this.qty = qty;
		this.price = price;
	}
    
    public boolean moreThan10(){
    	return this.qty>10?true:false;
    }
    
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
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + qty;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (qty != other.qty)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Item [name=" + name + ", qty=" + qty + ", price=" + price+"]";
	}
}
