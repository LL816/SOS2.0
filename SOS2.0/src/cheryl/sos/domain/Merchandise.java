package cheryl.sos.domain;

public class Merchandise {
	private int merchandiseId;
	private String merchandiseName;
	private float merchandisePrice;
	private int merchandiseRemaining;
	public int getMerchandiseId() {
		return merchandiseId;
	}
	public void setMerchandiseId(int merchandiseId) {
		this.merchandiseId = merchandiseId;
	}
	public String getMerchandiseName() {
		return merchandiseName;
	}
	public void setMerchandiseName(String merchandiseName) {
		this.merchandiseName = merchandiseName;
	}
	public float getMerchandisePrice() {
		return merchandisePrice;
	}
	public void setMerchandisePrice(float merchandisePrice) {
		this.merchandisePrice = merchandisePrice;
	}
	public int getMerchandiseRemaining() {
		return merchandiseRemaining;
	}
	public void setMerchandiseRemaining(int merchandiseRemaining) {
		this.merchandiseRemaining = merchandiseRemaining;
	}
	
}
