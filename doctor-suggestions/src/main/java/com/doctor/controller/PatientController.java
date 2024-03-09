package com.doctor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.doctor.entity.Doctor;
import com.doctor.entity.Patient;
import com.doctor.service.PatientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("patient")
public class PatientController {
	
	@Autowired
	private PatientService patientService;
	
	@PostMapping("add")
	public ResponseEntity<Patient> addPatient(@Valid @RequestBody Patient patient) throws Exception{
		patientService.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(patient);
	}
	@GetMapping("doctor-list/{pid}")
	public ResponseEntity<List<Doctor>>searchPatient(@PathVariable("pid") int pid) throws Exception{
		List<Doctor> doctorList = patientService.getDoctorList(pid);
		return ResponseEntity.ok(doctorList);
	}
	@DeleteMapping("delete/{pid}")
	public ResponseEntity<Patient> deletePatient(@PathVariable("pid") int pid) throws Exception{
		Patient p =patientService.deletePatient(pid);
	return ResponseEntity.ok(p);
	}

}
