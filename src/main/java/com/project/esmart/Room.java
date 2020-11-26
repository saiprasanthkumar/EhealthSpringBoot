package com.project.esmart;

public class Room {
	
	private Integer totalBeds;
	private String description;
	private Boolean isBooked;
	private Integer roomNo;
	
	
	public Integer getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(Integer roomNo) {
		this.roomNo = roomNo;
	}
	public Integer getTotalBeds() {
		return totalBeds;
	}
	public void setTotalBeds(Integer totalBeds) {
		this.totalBeds = totalBeds;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Boolean getIsBooked() {
		return isBooked;
	}
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}
	
	

}
