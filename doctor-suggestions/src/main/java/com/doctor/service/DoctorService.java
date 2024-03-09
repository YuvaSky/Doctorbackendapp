package com.doctor.service;

import com.doctor.entity.Doctor;

public interface DoctorService {

	  void saveDoctor(Doctor doctor);

	Doctor getDocker(int did);

	Doctor deleteDoctor(int did) throws Exception;

}
