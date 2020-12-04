package com.project.ehealth;

public class Appointment {
	private String patientDesc;
	private String patientId;
	private String doctorId;
	private String timing;
	private Boolean isAppointmentFixed;
	
	public String getPatientDesc() {
		return patientDesc;
	}
	public void setPatientDesc(String patientDesc) {
		this.patientDesc = patientDesc;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getTiming() {
		return timing;
	}
	public void setTiming(String timing) {
		this.timing = timing;
	}
	public Boolean getIsAppointmentFixed() {
		return isAppointmentFixed;
	}
	public void setIsAppointmentFixed(Boolean isAppointmentFixed) {
		this.isAppointmentFixed = isAppointmentFixed;
	}
	
	
}
