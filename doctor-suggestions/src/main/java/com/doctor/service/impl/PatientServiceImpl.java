package com.doctor.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doctor.Repository.DoctorRepository;
import com.doctor.Repository.PatientRepository;
import com.doctor.entity.Doctor;
import com.doctor.entity.Patient;
import com.doctor.exception.PatientNotFoundException;
import com.doctor.service.PatientService;
import com.doctor.util.DoctorPatient;

@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	private PatientRepository patientRepository;
	@Autowired DoctorRepository doctorRepository;

	public  void savePatient(Patient patient) throws Exception {
		this.patientRepository.addRecord(patient);
		
	}

	@Override
	public List<Doctor> getDoctorList(int pid) throws Exception {
		Patient patient = patientRepository.getPatient(pid);
		if(patient==null) {
			throw new PatientNotFoundException("Patient with id"+pid+" does not exist");
		}
		String city=patient.getCity();
		if(city.equals("Noida") && city.equals("Delhi") && city.equals("Faridabad")){
			throw new PatientNotFoundException("We are still waiting to expand to your location");
		}
		String speciality = DoctorPatient.map.get(patient.getSympton());
		List<Doctor> doclist = doctorRepository.findByCityandSpecialtiy(city,speciality);
		if(doclist.isEmpty()) {
			throw new PatientNotFoundException("There isn’t any doctor present at your location for your symptom");
		}
		return doclist;
	}

	@Override
	public Patient deletePatient(int pid) throws Exception {
	  Patient pat = patientRepository.getPatient(pid);
		if(pat== null) {
			throw new PatientNotFoundException("Patient with id"+pid+"does not exist");
		}
		patientRepository.deletePatient(pat);
		return pat;
		
	}

	}
