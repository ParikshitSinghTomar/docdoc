package in.main.app.rest.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.main.app.rest.dao.IClinicDao;
import in.main.app.rest.entity.Clinic;
import in.main.app.rest.entity.ClinicAddress;
import in.main.app.rest.entity.ClinicPhotos;
import in.main.app.util.DocLogger;

@Repository
@org.springframework.transaction.annotation.Transactional
public class ClinicDaoImpl implements IClinicDao {

	final static String className = ClinicDaoImpl.class.getName();

	private static void logD(String log) {
		DocLogger.debug(className + "--->" + log);
	}

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public ClinicAddress registerClinicAddress(ClinicAddress clinicAddress) {
		logD("registerClinic(Clinic clinic)-->" + clinicAddress.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			clinicAddress=(ClinicAddress)session.merge(clinicAddress);
			return clinicAddress;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public ClinicPhotos registerClinicPhotos(ClinicPhotos clinicPhotos) {
		logD("registerClinic(Clinic clinic)-->" + clinicPhotos.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			clinicPhotos=(ClinicPhotos)session.merge(clinicPhotos);
			return clinicPhotos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Clinic registerClinic(Clinic clinic) {
		logD("registerClinic(Clinic clinic)-->" + clinic.toString());
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(clinic);
			return clinic;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
