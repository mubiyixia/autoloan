package com.yooli.autoloan.common.util;

/**
 * 营业部ID和距离的键值对
 * 用于计算距离
 * @author TomXu
 * @since 2012-04-28
 *
 */
public class PositionDistanceCalculatorHelperBean {

	//营业部ID
	private Integer officeId;
	
	//营业部名称
	private String officeName;
	
	//距离
	private Double distance;

	public Integer getOfficeId() {
		return officeId;
	}

	public void setOfficeId(Integer officeId) {
		this.officeId = officeId;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
}
