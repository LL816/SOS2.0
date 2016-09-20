package cheryl.sos.domain;

public class Order {
	private float total_price;
	private float merchandisePrice;
	private String merchandiseName;
	private int num;
	private int order_id;
	public float getTotal_price() {
		return total_price;
	}
	public void setTotal_price(float total_price) {
		this.total_price = total_price;
	}
	public String getMerchandiseName() {
		return merchandiseName;
	}
	public void setMerchandiseName(String merchandise_name) {
		this.merchandiseName = merchandise_name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public float getMerchandisePrice() {
		return merchandisePrice;
	}
	public void setMerchandisePrice(float merchandisePrice) {
		this.merchandisePrice = merchandisePrice;
	}

}
