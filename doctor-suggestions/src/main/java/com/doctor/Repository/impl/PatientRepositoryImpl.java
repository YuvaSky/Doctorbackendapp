package com.doctor.Repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.doctor.Repository.PatientRepository;
import com.doctor.entity.Patient;

@Repository
public class PatientRepositoryImpl implements PatientRepository {
	
	private static Session session;
	private static Transaction transaction;
	
	
	public PatientRepositoryImpl(SessionFactory factory) {
		session=factory.openSession();
	    transaction = session.getTransaction();				
	}
	public  void addRecord(Patient patient)
	{
		transaction.begin();
		session.save(patient);
		transaction.commit();
	}
	@Override
	public Patient getPatient(int pid) {
		return session.get(Patient.class, pid);
	}
	@Override
	public void deletePatient(Patient pid) {
		transaction.begin();
		session.delete(pid);
		transaction.commit();
		
		
	} 
}
