package com.doctor.Repository;

import java.util.List;

import com.doctor.entity.Doctor;

public interface DoctorRepository  {


	  void addRecord(Doctor doctor);

	Doctor getDoctor(int did);

	 List<Doctor> findByCityandSpecialtiy(String city, String speciality);

	void deletePatient(Doctor doc);
}
