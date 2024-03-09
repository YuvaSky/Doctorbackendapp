package com.doctor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Repository.DoctorRepository;
import com.doctor.entity.Doctor;
import com.doctor.exception.DoctorNotFoundException;
import com.doctor.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	private DoctorRepository doctorRepository;

	public  void saveDoctor(Doctor doctor) {
		this.doctorRepository.addRecord(doctor);
		
	}

	@Override
	public Doctor getDocker(int did) {
		Doctor doctor = doctorRepository.getDoctor(did);
		if(doctor==null) {
			throw new DoctorNotFoundException("Doctor with id"+did+"not found");
		}
		return doctorRepository.getDoctor(did);
	}

	@Override
	public Doctor deleteDoctor(int did) throws Exception {
		Doctor doc = doctorRepository.getDoctor(did);
		if(doc== null) {
			throw new DoctorNotFoundException("Patient with id"+doc+"does not exist");
		}
		doctorRepository.deletePatient(doc);
		return doc;
		
		
	}
}
