package com.doctor.service;

import java.util.List;

import com.doctor.entity.Doctor;
import com.doctor.entity.Patient;

public interface PatientService {

	void savePatient(Patient patient) throws Exception;
 
	List<Doctor> getDoctorList(int pid) throws Exception;

	Patient deletePatient(int pid) throws Exception;

}
