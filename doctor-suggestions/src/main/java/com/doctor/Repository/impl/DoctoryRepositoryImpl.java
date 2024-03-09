package com.doctor.Repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.doctor.Repository.DoctorRepository;
import com.doctor.entity.Doctor;


@Repository
public class DoctoryRepositoryImpl implements DoctorRepository {
	
	private static Session session;
	private static Transaction transaction;
	
	
	public DoctoryRepositoryImpl(SessionFactory factory) {
		session=factory.openSession();
	    transaction = session.getTransaction();				
	}
	public  void addRecord(Doctor doctor)
	{
		transaction.begin();
		session.save(doctor);
		transaction.commit();
	}
	@Override
	public Doctor getDoctor(int did) {
		
		return session.get(Doctor.class, did);
	}
	@Override
	public List<Doctor> findByCityandSpecialtiy(String city, String speciality) {
	Query<Doctor> query=session.createQuery("from Doctor where city=:arg1 and speciality=:arg2");
	query.setParameter("arg1", city);
	query.setParameter("arg2", speciality);
	return query.list();
	}
	@Override
	public void deletePatient(Doctor doc) {
		transaction.begin();
		session.delete(doc);
		transaction.commit();
		
	} 
}
