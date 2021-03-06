package cri.promotion.monitortool.model;

import java.util.Date;

public class UnavailablePromotionModel {

	private Integer storeNumber;
	private Date startDate;
	private Date endDate;
	private Integer promotionId;
	private String storeStatus;
	private String description;

	public Integer getStoreNumber() {
		return storeNumber;
	}

	public void setStoreNumber(Integer storeNumber) {
		this.storeNumber = storeNumber;
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

	public Integer getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(Integer promotionId) {
		this.promotionId = promotionId;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	@Override
	public String toString() {
		return "UnablabelPromotionModel [storeNumber=" + storeNumber + ", startDate=" + startDate + ", endDate="
				+ endDate + ", promotionId=" + promotionId + "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
