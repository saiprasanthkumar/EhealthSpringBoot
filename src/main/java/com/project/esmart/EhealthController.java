package com.project.esmart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EhealthController {
	
	List<User> users = new ArrayList<User>();
	List<Patient> patients =  new ArrayList<Patient>();
	List<Doctor> doctors = new ArrayList<Doctor>();
	List<Room> rooms = new ArrayList<Room>();
	List<Appointment> appointments = new ArrayList<Appointment>();
	List<Medication> medication = new ArrayList<Medication>();
	List<Billing> billings = new ArrayList<Billing>();
	
	@PostMapping(path = "/updatepatient")
	public List<Patient> updatePatientDetails(@RequestBody Patient patient) {
		for (Patient patientIterate : patients) {
			if(patientIterate.getPatientId().equals(patient.getPatientId())) {
				patientIterate.setAmount(patient.getAmount());
			}
		}
		return null;
	}
	
	@PostMapping(path = "/book-room")
	public List<Room> updateRoomBooking(@RequestBody Room room) {
		for (Room roomIterate : rooms) {
			if(roomIterate.getRoomNo().equals(room.getRoomNo())) {
				roomIterate.setDescription(room.getDescription());
				roomIterate.setIsBooked(room.getIsBooked());
				roomIterate.setTotalBeds(room.getTotalBeds());
			}
		}
		return rooms;
	}
	
	@PutMapping(path = "/book/appointment")
	public List<Appointment> updateRoomBooking(@RequestBody Appointment appointment) {
		for (Appointment appointmentIterator : appointments) {
			if(appointmentIterator.getDoctorId().equals(appointment.getDoctorId())
					&& appointmentIterator.getPatientId().equals(appointment.getPatientId())) {
				appointmentIterator.setIsAppointmentFixed(appointment.getIsAppointmentFixed());
				appointmentIterator.setTiming(appointment.getTiming());
			}
		}
		return appointments;
	}
	
	@PostMapping(path = "/add/appointment")
	public List<Appointment> addAppointment(@RequestBody Appointment appointment) {
		this.appointments.add(appointment);
		return this.appointments;
	}
	
	@PostMapping(path = "/update-doctor")
	public List<Doctor> updateRoomBooking(@RequestBody Doctor doctor) {
		for (Doctor doctorIterate : doctors) {
			if(doctorIterate.getId().equals(doctor.getId())) {
				doctorIterate.setDescription(doctor.getDescription());
			}
		}
		return doctors;
	}

	
	
	@PostMapping(path = "/signup")
	public User addUser(@RequestBody User user) throws Exception {
		String userId = "";
		if(user.getType().equalsIgnoreCase("doctor")) {
			Doctor doctor = new Doctor();
			userId = (doctors.size()+1) + user.getUser();
			doctor.setId(userId);
			doctor.setName(user.getUser());
			this.doctors.add(doctor);
		}else if(user.getType().equalsIgnoreCase("patient")) {
			Patient patient = new Patient();
			userId = (patients.size() + 1)+  user.getUser();
			patient.setPatientId(userId);
			patient.setPatientName(user.getUser());
			this.patients.add(patient);
		}else {
			userId = users.size() +  user.getUser();
		}
		user.setUserId(userId);
		users.add(user);
		return user;
	}
	
	@PostMapping(path = "/login")
	public User compareUser(@RequestBody User user) throws Exception {
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getUser().equals(user.getUser())) {
				if(!user.getPassword().equals(users.get(i).getPassword())) {
					throw new Exception("Password did not match");
				}
				if(!user.getType().equalsIgnoreCase(users.get(i).getType())) {
					throw new Exception("User Type did not match");
				}
			}
		}
		if(user.getType().equalsIgnoreCase("doctor")) {
			for (Doctor doctor : doctors) {
				if(doctor.getId().equals(user.getUserId())) {
					return user;
				}
		}
		}
		if(user.getType().equalsIgnoreCase("patient")) {
			for (Patient patient : patients) {
				if(patient.getPatientId().equals(user.getUserId())) {
					return user;
				}
			}
		
		}
		throw new Exception("Please enter correct credential");
	}
	
	@GetMapping(path = "/view/appointment")
	public List<Appointment> getAppointment() {
		return appointments;
	}
	@GetMapping(path = "/view/patient")
	public List<Patient> getPatient() {
		return patients;
	}
	@GetMapping(path = "/view/doctor")
	public List<Doctor> getDoctor() {
		return doctors;
	}
	@GetMapping(path = "/view/room")
	public List<Room> getBeds() {
		return this.rooms;
	}
	@PostMapping(path = "/add/room")
	public List<Room> addBeds(@RequestBody Room room) {
		this.rooms.add(room);
		return rooms;
	}
	@GetMapping(path = "/view/medication")
	public List<Medication> viewMedication() {
		return this.medication;
	}
	@PostMapping(path = "/add/medication")
	public List<Medication> getMedication(@RequestBody Medication medication) {
		for (Medication medicationIt : this.medication) {
			if(medicationIt.getPatientId().equals(medication.getPatientId())) {
				StringBuilder str = new StringBuilder(medicationIt.getDescription());
				str.append(medication.getDescription());
				medicationIt.setDescription(str.toString());
				return this.medication;
			}
		}
		this.medication.add(medication);
		return this.medication;
	}
	@PostMapping(path = "/add/billing")
	public List<Billing> addBilling(@RequestBody Billing billing) {
		for (Billing billingIte : billings) {
			if(billingIte.getPatientId().equals(billing.getPatientId())) {
				billingIte.setAmount(billing.getAmount());
				billingIte.setDescription(billing.getDescription());
				billingIte.setPayed(billing.isPayed());
				return billings;
			}
		}
		this.billings.add(billing);
		return billings;
	}
	@GetMapping(path = "/view/billing")
	public List<Billing> viewBilling() {
		return this.billings;
	}
}
