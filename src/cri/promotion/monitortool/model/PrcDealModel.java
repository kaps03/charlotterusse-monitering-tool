package cri.promotion.monitortool.model;

import java.util.Date;

public class PrcDealModel {
	private Integer organizationId;
	private String dealId;
	private String orgCode;
	private String orgValue;
	private String description;
	private Short actDeferred;
	private Date effectiveDate;
	private Date endDate;
	private Date startTime;
	private Date endTime;
	private Double generosityCap;
	private Integer iterationCap;
	private Integer priorityNudge;
	private Double subtotalMin;
	private Double subtotalMax;
	private String trwideAction;
	private Double trwideAmount;
	private String taxabilityCode;
	private String promotionId;
	private Short higherNonactionAmtFlag;
	private Short excludePriceOverrideFlag;
	private Short excludeDiscountedFlag;
	private Short targetedFlag;
	private Date createDate;
	private String createUserId;
	private Date updateDate;
	private String updateUserId;
	private String recordState;
	private Short weekSchedFlag;

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public String getOrgValue() {
		return orgValue;
	}

	public void setOrgValue(String orgValue) {
		this.orgValue = orgValue;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Short getActDeferred() {
		return actDeferred;
	}

	public void setActDeferred(Short actDeferred) {
		this.actDeferred = actDeferred;
	}

	public Date getEffectiveDate() {
		return effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Double getGenerosityCap() {
		return generosityCap;
	}

	public void setGenerosityCap(Double generosityCap) {
		this.generosityCap = generosityCap;
	}

	public Integer getIterationCap() {
		return iterationCap;
	}

	public void setIterationCap(Integer iterationCap) {
		this.iterationCap = iterationCap;
	}

	public Integer getPriorityNudge() {
		return priorityNudge;
	}

	public void setPriorityNudge(Integer priorityNudge) {
		this.priorityNudge = priorityNudge;
	}

	public Double getSubtotalMin() {
		return subtotalMin;
	}

	public void setSubtotalMin(Double subtotalMin) {
		this.subtotalMin = subtotalMin;
	}

	public Double getSubtotalMax() {
		return subtotalMax;
	}

	public void setSubtotalMax(Double subtotalMax) {
		this.subtotalMax = subtotalMax;
	}

	public String getTrwideAction() {
		return trwideAction;
	}

	public void setTrwideAction(String trwideAction) {
		this.trwideAction = trwideAction;
	}

	public Double getTrwideAmount() {
		return trwideAmount;
	}

	public void setTrwideAmount(Double trwideAmount) {
		this.trwideAmount = trwideAmount;
	}

	public String getTaxabilityCode() {
		return taxabilityCode;
	}

	public void setTaxabilityCode(String taxabilityCode) {
		this.taxabilityCode = taxabilityCode;
	}

	public String getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(String promotionId) {
		this.promotionId = promotionId;
	}

	public Short getHigherNonactionAmtFlag() {
		return higherNonactionAmtFlag;
	}

	public void setHigherNonactionAmtFlag(Short higherNonactionAmtFlag) {
		this.higherNonactionAmtFlag = higherNonactionAmtFlag;
	}

	public Short getExcludePriceOverrideFlag() {
		return excludePriceOverrideFlag;
	}

	public void setExcludePriceOverrideFlag(Short excludePriceOverrideFlag) {
		this.excludePriceOverrideFlag = excludePriceOverrideFlag;
	}

	public Short getExcludeDiscountedFlag() {
		return excludeDiscountedFlag;
	}

	public void setExcludeDiscountedFlag(Short excludeDiscountedFlag) {
		this.excludeDiscountedFlag = excludeDiscountedFlag;
	}

	public Short getTargetedFlag() {
		return targetedFlag;
	}

	public void setTargetedFlag(Short targetedFlag) {
		this.targetedFlag = targetedFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getRecordState() {
		return recordState;
	}

	public void setRecordState(String recordState) {
		this.recordState = recordState;
	}

	public Short getWeekSchedFlag() {
		return weekSchedFlag;
	}

	public void setWeekSchedFlag(Short weekSchedFlag) {
		this.weekSchedFlag = weekSchedFlag;
	}

	@Override
	public String toString() {
		return "PrcDealModel [organizationId=" + organizationId + ", dealId=" + dealId + ", orgCode=" + orgCode
				+ ", orgValue=" + orgValue + ", description=" + description + ", actDeferred=" + actDeferred
				+ ", effectiveDate=" + effectiveDate + ", endDate=" + endDate + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", generosityCap=" + generosityCap + ", iterationCap=" + iterationCap
				+ ", priorityNudge=" + priorityNudge + ", subtotalMin=" + subtotalMin + ", subtotalMax=" + subtotalMax
				+ ", trwideAction=" + trwideAction + ", trwideAmount=" + trwideAmount + ", taxabilityCode="
				+ taxabilityCode + ", promotionId=" + promotionId + ", higherNonactionAmtFlag=" + higherNonactionAmtFlag
				+ ", excludePriceOverrideFlag=" + excludePriceOverrideFlag + ", excludeDiscountedFlag="
				+ excludeDiscountedFlag + ", targetedFlag=" + targetedFlag + ", createDate=" + createDate
				+ ", createUserId=" + createUserId + ", updateDate=" + updateDate + ", updateUserId=" + updateUserId
				+ ", recordState=" + recordState + ", weekSchedFlag=" + weekSchedFlag + "]";
	}
	
}
