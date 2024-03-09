package com.doctor.Repository;

import com.doctor.entity.Patient;

public interface PatientRepository {

	void addRecord(Patient patient);
	Patient getPatient(int pid);
	void deletePatient(Patient pid);

}
