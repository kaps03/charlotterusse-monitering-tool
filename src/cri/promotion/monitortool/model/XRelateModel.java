package cri.promotion.monitortool.model;

import java.util.Date;

public class XRelateModel {

	private Integer promotionId;
	private Date startDate;
	private Date endDate;
	private String attributeName;
	private Integer storeNumber;

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public Integer getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(Integer storeNumber) {
		this.storeNumber = storeNumber;
	}

	@Override
	public String toString() {
		return "XRelateModel [promotionId=" + promotionId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", attributeName=" + attributeName + ", storeNumber=" + storeNumber + "]";
	}

}
